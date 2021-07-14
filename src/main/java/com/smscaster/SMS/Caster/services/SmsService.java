package com.smscaster.SMS.Caster.services;

import com.smscaster.SMS.Caster.config.TwilioSmsSender;
import com.smscaster.SMS.Caster.models.SMSs;
import com.smscaster.SMS.Caster.repositories.ISMSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsService {

  private final ISMSRepository smsSender;

  @Autowired
  public SmsService(@Qualifier("twilio") TwilioSmsSender smsSender) {
    this.smsSender = smsSender;
  }

  public void sendSms(SMSs smsRequest) {
    smsSender.sendSms(smsRequest);
  }
}
