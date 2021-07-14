package com.smscaster.SMS.Caster.repositories;

import com.smscaster.SMS.Caster.models.SMSs;

public interface ISMSRepository {
  void sendSms(SMSs messages);
  // or maybe void sendSms(String phoneNumber, String message);
}
