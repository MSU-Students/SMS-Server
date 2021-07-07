package com.smscaster.SMS.Caster.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipient")
public class Recipients {

  @Id
  private ObjectId _id;

  private String firstName;
  private String lastName;
  private String institution;
  private String status;
  private String contact;

  public Recipients(String firstName, String lastName, String institution, String status, String contact) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.institution = institution;
    this.status = status;
    this.contact = contact;
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

  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }
  
}
