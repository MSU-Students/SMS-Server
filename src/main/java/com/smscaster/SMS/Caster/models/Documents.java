package com.smscaster.SMS.Caster.models;

import java.io.File;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "document")
public class  Documents {

  @Id
  private ObjectId _id;

  private String name;
  private String subject;
  private String docType;
  private String date;
  private String file;

  public Documents(String name, String subject, String docType, String date, String file) {
    this.name = name;
    this.subject = subject;
    this.docType = docType;
    this.date = date;
    this.file = file;
  }

  public String get_id() {
    return _id.toHexString();
  }

  public void set_id(ObjectId _Id) {
    this._id = _Id;
  }

  public String getname() {
    return name;
  }

  public void setname(String name) {
    this.name = name;
  }

  public String getsubject() {
    return subject;
  }

  public void setsubject(String subject) {
    this.subject = subject;
  }

  public String getdocType() {
    return docType;
  }

  public void setdocType(String docType) {
    this.docType = docType;
  }

  public String getdate() {
    return date;
  }

  public void setdate(String date) {
    this.date = date;
  }

  public String getfile() {
    return file;
  }

  public void setfile(String file) {
    this.file = file;
  }
}
