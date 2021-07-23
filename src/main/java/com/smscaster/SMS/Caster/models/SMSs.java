package com.smscaster.SMS.Caster.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Document(collection = "message")
public class SMSs {

  @NonNull
  private final String phoneNumber; // destination

  @NonNull
  private final String message;

  private String subject;

  public SMSs(@JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("message") String message,
      String subject) {
    this.phoneNumber = phoneNumber;
    this.message = message;
    this.setSubject(subject);
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return ("SmsRequest{" + "phoneNumber= ..." + '\'' + ", message='" + message + '\'' + '}');
  }
}
