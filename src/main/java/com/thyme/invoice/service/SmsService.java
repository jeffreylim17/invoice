package com.thyme.invoice.service;

import com.thyme.invoice.model.SendSmsDTO;
import java.util.Optional;

public interface SmsService {

  Optional<com.twilio.rest.api.v2010.account.Message> sendMessage(SendSmsDTO sendSmsDTO);
}
