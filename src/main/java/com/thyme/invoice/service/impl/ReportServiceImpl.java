package com.thyme.invoice.service.impl;

import com.thyme.invoice.model.InvoiceReportDTO;
import com.thyme.invoice.service.ReportService;
import com.thyme.invoice.utility.ReportConstants;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleHtmlReportConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {

  @Value("${report.output.invoice}")
  private String invoiceOutputPath;

  @Override
  public ResponseEntity<String> generateReport(InvoiceReportDTO invoiceReportPayload) {
    log.info("Invoice Report Generation START ::: [{}]", invoiceReportPayload.getInvoice().getId());
    InputStream employeeReportStream = getClass().getResourceAsStream(
        ReportConstants.INVOICE_TEMPLATE);

    try {
      JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(
          invoiceReportPayload.getInvoiceDetailsList());

      JasperReport jasperReport = JasperCompileManager.compileReport(employeeReportStream);
      Map<String, Object> parameters = new HashMap<>();

      parameters.put("STORE_NAME", invoiceReportPayload.getStoreLocal().getStoreName());
      parameters.put("STORE_ADDRESS", invoiceReportPayload.getStoreLocal().getStoreAddress());

      parameters.put("CASHIER_NAME", invoiceReportPayload.getInvoice().getCashiername());
      parameters.put("INV_NUM", invoiceReportPayload.getInvoice().getInvnum());
      parameters.put("SEQ", invoiceReportPayload.getInvoice().getSeqInShift().toString());

      String[] stationIdSeparator = invoiceReportPayload.getInvoice().getStationID().split("_");

      parameters.put("STATION_NUMBER", stationIdSeparator[stationIdSeparator.length - 1]);
      Date date = new Date(invoiceReportPayload.getInvoice().getInvdate());
      DateFormat format = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
      parameters.put("INVOICE_DATETIME",
          format.format(date));

      parameters.put("ITEM_COUNT", String.valueOf(invoiceReportPayload.getInvoiceDetailsList().size()));
      parameters.put("ITEM_TOTAL",
          invoiceReportPayload.getInvoice().getTotalPrice());
      parameters.put("TAX_RATE", invoiceReportPayload.getInvoice().getTaxrate1percent().toString());
      parameters.put("TAX_TOTAL",
          invoiceReportPayload.getInvoice().getTotalTax1()); // for updating
      parameters.put("AMOUNT_TENDERED",
          invoiceReportPayload.getInvoice().getAmtTendered());
      parameters.put("CHANGE", invoiceReportPayload.getInvoice().getAmtChange());

      /** CTRX */

      if (invoiceReportPayload.getCtrx().isPresent()) {
        parameters.put("IS_CTRX", true);
        parameters.put("TRANSACTION_TYPE", invoiceReportPayload.getInvoice().getOrderTypeName());
        parameters.put("AUTHORIZATION", invoiceReportPayload.getCtrx().get().getIsTransactionApproved());

        if (invoiceReportPayload.getMagtekHwTrx().isPresent()) {
          log.info("APPROVAL_CODE [{}]", invoiceReportPayload.getMagtekHwTrx().get().getAuthCode());
          parameters.put("APPROVAL_CODE", invoiceReportPayload.getMagtekHwTrx().get().getAuthCode());
        }
        parameters.put("PAYMENT_ID", invoiceReportPayload.getCtrx().get().getTroutD());
        parameters.put("APPLICATION_ID", invoiceReportPayload.getCtrx().get().getId());
        parameters.put("APPLICATION_LABEL", invoiceReportPayload.getCtrx().get().getAppLabel());
        parameters.put("ENTRY_MODE", invoiceReportPayload.getCtrx().get().getCardEntrySource());
      }
      /**
       *
       */
      JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,
          collectionDataSource);
      SimpleHtmlReportConfiguration config = new SimpleHtmlReportConfiguration();
      config.setZoomRatio(3f);

      HtmlExporter exporter = new HtmlExporter();

      exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
      exporter.setConfiguration(config);
      exporter.setExporterOutput(
          new SimpleHtmlExporterOutput(
              invoiceOutputPath + invoiceReportPayload.getFileName()));
      exporter.exportReport();

    } catch (JRException e) {
      log.error("Error ::: [{}]", e.getLocalizedMessage());
    }
    return ResponseEntity.ok("Successful");
  }
}
