package com.smscaster.SMS.Caster.controllers;

import com.smscaster.SMS.Caster.models.Messages;
import com.smscaster.SMS.Caster.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sms-api/message")
public class MessageController {

  private final Service service;

  @Autowired
  public MessageController(Service service) {
    this.service = service;
  }

  @PostMapping
  public void sendSms(@Validated @RequestBody Messages smsRequest) {
    service.sendSms(smsRequest);
  }
}
