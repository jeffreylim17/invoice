package com.thyme.invoice.service.impl;

import static com.thyme.invoice.utility.ReportConstants.HTML_FILE_FORMAT;

import com.thyme.invoice.model.InvoiceReportDTO;
import com.thyme.invoice.model.SendSmsDTO;
import com.thyme.invoice.service.InvoiceService;
import com.thyme.invoice.service.ReportService;
import com.thyme.invoice.service.SmsService;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

  @Value("${baseUrl}")
  private String baseUrl;

  @Value("${url.invoice}")
  private String invoiceUrl;

  @Autowired
  private ReportService reportService;

  @Autowired
  private SmsService smsService;

  @Override
  public ResponseEntity<String> generateAndSendInvoice(InvoiceReportDTO invoiceReportDTO) {
    /** Q: How to check where should the message be coming from **/
    String fileName = Instant.now().getEpochSecond() + "_" + invoiceReportDTO.getInvoice().getInvnum() + HTML_FILE_FORMAT;

    SendSmsDTO sendSmsDTO = new SendSmsDTO();
    sendSmsDTO.setTo(invoiceReportDTO.getPhoneNumber());
    sendSmsDTO.setFrom("MGc2033c62834e77037be5953fc86daa61");
    sendSmsDTO.setMessage(baseUrl + invoiceUrl + fileName);
    sendSmsDTO.setAccountSID("AC1290e8a3aa50cb8c39baf5a6625b3deb");
    sendSmsDTO.setAuthToken("d6d536a49e86c07ea293e7b58868ae5d");

    log.info("Before trigger Generate");
    CompletableFuture.runAsync(() -> reportService.generateReport(invoiceReportDTO.fileName(fileName)))
        .thenRun(() -> smsService.sendMessage(sendSmsDTO));

    return ResponseEntity.ok(invoiceReportDTO.getInvoice().getInvnum());
  }
}
