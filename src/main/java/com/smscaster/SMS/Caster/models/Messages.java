package com.smscaster.SMS.Caster.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

public class Messages {

  @NonNull
  private final String phoneNumber; // destination

  @NonNull
  private final String message;

  public Messages(
    @JsonProperty("phoneNumber") String phoneNumber,
    @JsonProperty("message") String message
  ) {
    this.phoneNumber = phoneNumber;
    this.message = message;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public String toString() {
    return (
      "SmsRequest{" +
      "phoneNumber= ..." +
      '\'' +
      ", message='" +
      message +
      '\'' +
      '}'
    );
  }
}
