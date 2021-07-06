package com.smscaster.SMS.Caster.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "officer")
public class Officer {

  @Id
  private ObjectId _id;

  private String firstName;
  private String lastName;
  private String contact;
  private String password;

  public Officer(String firstName, String lastName, String contact, String password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.contact = contact;
    this.password = password;
  }

  public String get_id() {
    return _id.toHexString();
  }

  public void set_id(ObjectId _Id) {
    this._id = _Id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getcontact() {
    return contact;
  }

  public void setcontact(String contact) {
    this.contact = contact;
  }

  public String getpassword() {
    return password;
  }

  public void setpassword(String password) {
    this.password = password;
  }
}
