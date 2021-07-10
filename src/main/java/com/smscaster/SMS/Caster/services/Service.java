package com.smscaster.SMS.Caster.services;

import com.smscaster.SMS.Caster.config.TwilioSmsSender;
import com.smscaster.SMS.Caster.models.Messages;
import com.smscaster.SMS.Caster.repositories.IMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class Service {

  private final IMessageRepository smsSender;

  @Autowired
  public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
    this.smsSender = smsSender;
  }

  public void sendSms(Messages smsRequest) {
    smsSender.sendSms(smsRequest);
  }
}
