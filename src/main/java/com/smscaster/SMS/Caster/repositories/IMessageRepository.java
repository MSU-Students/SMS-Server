package com.smscaster.SMS.Caster.repositories;

import com.smscaster.SMS.Caster.models.Messages;

public interface IMessageRepository {
  void sendSms(Messages messages);
  // or maybe void sendSms(String phoneNumber, String message);
}
