package com.smscaster.SMS.Caster.controllers;

import com.sinch.xms.ApiConnection;
import com.sinch.xms.SinchSMSApi;
import com.sinch.xms.api.MtBatchTextSmsCreate;
import com.sinch.xms.api.MtBatchTextSmsResult;
import com.smscaster.SMS.Caster.models.IncomingSMS;
import com.smscaster.SMS.Caster.models.SMSModel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SendSmsController {

  private static final String SERVICE_PLAN_ID = "";
  private static final String TOKEN = "";
  private static String SENDER = "447537455333"; // This is the a sinch number from your dasbhoard. in e164 format
  private static ApiConnection conn;

  @PostMapping("/sms/send")
  public MtBatchTextSmsResult sendSMS(@RequestBody SMSModel sms) {
    String[] to = { sms.ToPhonenumber };
    MtBatchTextSmsCreate message = SinchSMSApi
      .batchTextSms()
      .sender(SENDER)
      .addRecipient(to)
      .body(sms.Body)
      .build();
    try {
      MtBatchTextSmsResult batch = conn.createBatch(message);
      return batch;
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }

  /**
   * Supports the webhook callbacks you recieve after you configre the callback
   * url at https://dashboard.sinch.com/sms/api/rest/ for your service id Please
   * be aware it can take up to a minute before and update to a callback url has
   * propagated everywhere.
   */
  @PostMapping("/")
  public ResponseEntity<Object> receiveInbound(
    @RequestBody IncomingSMS incoming
  ) {
    System.out.println(incoming);
    //send an autoreply back
    String[] to = { incoming.sender };
    MtBatchTextSmsCreate message = SinchSMSApi
      .batchTextSms()
      .sender(SENDER)
      .addRecipient(to)
      .body("Automated reply")
      .build();
    try {
      MtBatchTextSmsResult batch = conn.createBatch(message);
      System.out.println(batch);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return new ResponseEntity<>("Accepted", HttpStatus.OK);
  }
}
