package com.smscaster.SMS.Caster.models;

import javax.annotation.Nullable;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IncomingSMS {

    /**
     * The unique message identifier.
     * 
     * @return a message identifier
     */
    public String id;

    /**
     * The originating MSISDN.
     * 
     * @return an originating address
     */
    @JsonProperty("from")
    public String sender;

    /**
     * The recipient of this mobile originated message. For example an MSISDN or
     * short code.
     * 
     * @return the recipient address
     */
    @JsonProperty("to")
    public String recipient;

    public String body;
    /**
     * The MCCMNC of the originating operator, if available.
     * 
     * @return an MCCMNC or <code>null</code> if none is available
     */
    @Nullable
    public String operator;

    /**
     * Timestamp for when this message was sent. 2021-01-27T04:39:59.768Z
     * 
     * @return the time of sending
     */
    @JsonProperty("sent_at")
    @Nullable
    public String sentAt;

    /**
     * Timestamp for when the messaging system received the message.
     * 
     * @return the time of receiving
     */
    @JsonProperty("received_at")
    public String receivedAt;
}




/**
 * Base class for mobile originated messages. A mobile originated message can
 * have either a {@link MoTextSms textual} or a {@link MoBinarySms binary}
 * message payload.
 */
