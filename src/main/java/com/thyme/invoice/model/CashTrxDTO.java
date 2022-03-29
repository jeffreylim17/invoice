package com.thyme.invoice.model;

import lombok.Data;

@Data
public class CashTrxDTO {

  private String id;

  private Double amount;

  private String employeeID;

  private Long dateAndTime;

  private String invoiceID;

  private String invNum;

  private String dayId;

  private Long lastUpdated;

  private String paymentMethodId;

  private String shiftId;

  private String stationID;

  private String storeID;

  private String status;

  private Double tipAmount;

  private Double amtChange;

  private Double amtTendered;

  private Double discountAmount;

  private Double actualAmount;

  private Integer uploaded;

}
