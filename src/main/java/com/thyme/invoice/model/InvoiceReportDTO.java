package com.thyme.invoice.model;

import java.util.List;
import java.util.Optional;
import lombok.Data;

@Data
public class InvoiceReportDTO {

  private String fileName;
  private String phoneNumber;
  private InvoiceDTO invoice;
  private List<InvoiceDetailsDTO> invoiceDetailsList;
  private Optional<CashTrxDTO> cashTrx;
  private Optional<CtrxDTO> ctrx;
  private StoreLocalDTO storeLocal;
  private Optional<MagtekHwTrxDTO> magtekHwTrx;

  public InvoiceReportDTO() {
  }

  public InvoiceReportDTO fileName(String fileName) {
    this.fileName = fileName;
    return this;
  }

}
