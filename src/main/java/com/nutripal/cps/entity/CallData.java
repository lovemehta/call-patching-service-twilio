package com.nutripal.cps.entity;

import java.util.Currency;
import java.util.Map;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import com.twilio.rest.api.v2010.account.Call;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "call_data")
public class CallData extends AbstractEntity {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Column(name = "sid")
  private String sid;

  @Column(name = "date_created")
  private String dateCreated;

  @Column(name = "date_updated")
  private String dateUpdated;

  @Column(name = "parent_call_sid")
  private String parentCallSid;

  @Column(name = "account_sid")
  private String accountSid;

  @Column(name = "to")
  private String to;

  @Column(name = "to_formatted")
  private String toFormatted;

  @Column(name = "from")
  private String from;

  @Column(name = "from_formatted")
  private String fromFormatted;

  @Column(name = "phone_number_sid")
  private String phoneNumberSid;

  @Column(name = "status")
  private Call.Status status;

  @Column(name = "start_time")
  private String startTime;

  @Column(name = "end_time")
  private String endTime;

  @Column(name = "duration")
  private String duration;

  @Column(name = "price")
  private String price;

  @Column(name = "price_unit")
  private Currency priceUnit;

  @Column(name = "direction")
  private String direction;

  @Column(name = "answered_by")
  private String answeredBy;

  @Column(name = "annotation")
  private String annotation;

  @Column(name = "api_version")
  private String apiVersion;

  @Column(name = "forwarded_from")
  private String forwardedFrom;

  @Column(name = "group_sid")
  private String groupSid;

  @Column(name = "caller_name")
  private String callerName;

  @Column(name = "queue_time")
  private String queueTime;

  @Column(name = "trunk_sid")
  private String trunkSid;

  @Column(name = "uri")
  private String uri;

  @Column(name = "subresource_uris")
  private Map<String, String> subresourceUris;

  @Column(name = "callback_source")
  private String callbackSource;


}
