package com.thyme.invoice.service;

import com.thyme.invoice.model.InvoiceReportDTO;
import org.springframework.http.ResponseEntity;

public interface ReportService {

  ResponseEntity<String> generateReport(InvoiceReportDTO invoiceReportPayload);

}
