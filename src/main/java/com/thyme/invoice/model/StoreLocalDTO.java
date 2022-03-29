package com.thyme.invoice.model;

import java.util.List;
import lombok.Data;

@Data
public class StoreLocalDTO {

  private String id;

  private String storeAddress;

  private String storeCity;

  private String storeName;

  private String storePhone;

  private String storeState;

  private Integer storeZip;

  private Integer storeNum;

  private String invoiceNotes;

  private Long lastUpdated;

  private String logoLocation;

  private Integer numStations;

  private Boolean open;

  private Long openTime;

  private Long closeTime;

  private String storeEmail;

  private String taxId;

  private Double taxRate;

  private String timeText;

  private String locationID;

  private String companyID;

  private String businessTypeId;

  private String logoIMG;

  private List<String> addlEmails;

  private String storeColor;

  private Double discountPercent;

  private Boolean enableEndOfDay;

  private Boolean enableEndOfWeek;

  private Boolean enableAuditLog;

  private Boolean auditDeletedItems;

  private Boolean auditVoidedInvoices;

  private Boolean auditOpenCashDrawer;

  private Boolean auditReturns;

  private Boolean auditDiscount;

  private Boolean enableHouseFee;

  private Integer houseFeePercent;

  private String smsNumber;

  private String clientId;

  private Long endOfDayTime;

  private Boolean enableCashDiscount;

  private Boolean multipleTaxes;

  private Boolean useItemKds;

  private Boolean useItemPrinter;

  private Boolean enableLoyaltyCur;

  private Boolean enableLoyaltyPointsItem;

  private Boolean useOnlineReward;

  private Boolean useProvider;

  private String loyaltyProvider;

  private Boolean enableHappyHour;

  private Boolean enableCombo;

  private Boolean forceDiscountsReason;

}
