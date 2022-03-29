package com.thyme.invoice.model;

import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class InvoiceDTO {

  private String id;

  private Double additionalTip;

  private Double amtChange;

  private Double amtTendered;

  private Double amtdeposit;

  private Double caamount;

  private String cashierid;

  private String cashiername;

  private Double ccamount;

  private Long createdate;

  private String custNum;

  private Long day;

  private String dayId;

  private Double dcamount;

  private Double discountAmount;

  private Double discountPercent;

  private Double fsamount;

  private Double grandTotal;

  private Long invdate;

  private String invnum;

  private Long invtime;

  private String kioskid;

  private Long lastUpdated;

  private String layaway;

  private Double layawayamount;

  private Long modifieddate;

  private Double nonTaxedsales;

  private String notes;

  private Double oaamount;

  private String onlineorderid;

  private String orderNum;

  private String orderSource;

  private String paymentMethod;

  private String shiftID;

  private Boolean splitPaymentMethod;

  private Boolean invSplit;

  private String stationID;

  private String status;

  private String storeID;

  private Double taxed1;

  private Double taxedSales;

  private Double taxexemptsales;

  private Double taxrate1percent;

  private String taxrateid;

  private Double taxEx;

  private Double taxIn;

  private Boolean tipadded;

  private Double tipamount;

  private Double totalCost;

  private Double totalPrice;

  private Double totalTax1;

  private Double totalTax2;

  private Double totalTax3;

  private Long week;

  private Long month;

  private Long year;

  private Long timestamp;

  private Long lastMod;

  private String employeeID;

  private String employeeName;

  private String companyId;

  private String customerPhoneNumber;

  private Integer seqInShift;

  private List<String> creditCardImage;

  private Map<String, String> idImage;

  private String closedByStation;


  private String closedByEmployee;


  private String onHoldName;

  private String orderTypeId;

  private String orderTypeName;

  private Double tipPercent;

  private String pType;

  private Double refundAmount;
}
