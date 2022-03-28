package com.thyme.invoice.model;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SendSmsDTO {

  @NotNull
  @NotBlank
  private String authToken;
  @NotNull
  @NotBlank
  private String accountSID;
  @NotNull
  @NotBlank
  private String from;
  @NotNull
  @NotBlank
  private String to;
  @NotNull
  @NotBlank
  private String message;

}
