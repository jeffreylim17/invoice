package com.thyme.invoice.model;

import java.util.List;
import lombok.Data;

@Data
public class InvoiceDetailsDTO {

  private String id;

  private Double cqty;

  private Double discountPercent;

  private String invNum;

  private String invoiceItemModifierIds;

  private Integer invoiceLineNum;

  private Long invoiceTimeAndDate;

  private String itemId;

  private String itemName;

  private String itemNum;

  private Double itemPrice;

  private Long lastUpdated;

  private Double qty;

  private String skuId;

  private String storeID;

  private String stationID;

  private String companyId;

  private String groupId;

  private Boolean taxable;

  private Double tipPercent;

  private List<String> taxTypes;

  private Boolean changed;

  private List<String> kpID;

  private List<String> kdsID;

  private String readyStatus;

  private String shiftId;

  private Boolean refunded;

  private String status;

  private String deptID;
}
