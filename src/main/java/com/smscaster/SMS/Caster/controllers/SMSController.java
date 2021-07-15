package com.smscaster.SMS.Caster.controllers;

import com.smscaster.SMS.Caster.models.SMSs;
import com.smscaster.SMS.Caster.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/sms-api/message")
public class SMSController {

  private final SmsService service;

  @Autowired
  public SMSController(SmsService service) {
    this.service = service;
  }

  @ApiOperation(value = "Send some sms", nickname = "SendSms")
  @PostMapping
  public void sendSms(@Validated @RequestBody SMSs smsRequest) {
    System.out.println(smsRequest);
    service.sendSms(smsRequest);
  }
}
