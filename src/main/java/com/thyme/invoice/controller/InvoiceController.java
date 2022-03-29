package com.thyme.invoice.controller;

import com.thyme.invoice.model.InvoiceReportDTO;
import com.thyme.invoice.service.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InvoiceController {

  @GetMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  private InvoiceService invoiceService;

  @PostMapping

  public ResponseEntity<String> postInvoice(InvoiceReportDTO invoiceReportDTO) {
    return invoiceService.generateAndSendInvoice(invoiceReportDTO);
  }

}
