package com.thyme.invoice.service.impl;

import com.thyme.invoice.model.SendSmsDTO;
import com.thyme.invoice.service.SmsService;
import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsServiceImpl implements SmsService {

  @Override
  public Optional<com.twilio.rest.api.v2010.account.Message> sendMessage(SendSmsDTO sendSmsDTO) {
    Twilio.init(sendSmsDTO.getAccountSID(), sendSmsDTO.getAuthToken());
    com.twilio.rest.api.v2010.account.Message message = com.twilio.rest.api.v2010.account.Message.creator(
        new PhoneNumber(sendSmsDTO.getTo()), new PhoneNumber(sendSmsDTO.getFrom()),
        sendSmsDTO.getMessage()).create();

    log.info(" Twilio send sms result ::: [{}]", message);
    return Optional.of(message);
  }
}