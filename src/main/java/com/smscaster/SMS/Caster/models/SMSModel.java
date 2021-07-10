package com.smscaster.SMS.Caster.models;

/**
 * Simple SMS Model that takes to and body parameter
 */
public class SMSModel {

  /**
   * phonenumber to send sms To in e164 format
   * example: +15612600684
   */
  public String ToPhonenumber;

  /**
   * Content of the SMS message
   */
  public String Body;
}
