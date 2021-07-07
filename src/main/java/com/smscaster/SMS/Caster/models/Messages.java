package com.smscaster.SMS.Caster.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
public class Messages {

  @Id
  private ObjectId _id;

  private String sms;
  private String recipient;
  

  public Messages(String sms, String recipient) {
    this.sms = sms;
    this.recipient = recipient;
  }

  public String get_id() {
    return _id.toHexString();
  }

  public void set_id(ObjectId _Id) {
    this._id = _Id;
  }

  public String getsms() {
    return sms;
  }

  public void setsms(String sms) {
    this.sms = sms;
  }

  public String getrecipient() {
    return recipient;
  }

  public void setrecipient(String recipient) {
    this.recipient = recipient;
  }
}
