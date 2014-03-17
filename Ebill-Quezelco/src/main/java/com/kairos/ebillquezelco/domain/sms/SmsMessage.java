package com.kairos.ebillquezelco.domain.sms;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblSmsMessage")
public class SmsMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5812027512788285456L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String apiKey;
	private String senderName;
	private String accountNum;
	private String recipientName;
	private String recipientNum;
	private String message;
	private Date messageSentDate;
	private Boolean isSuccessfullySent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getApiKey() {
		return apiKey;
	}
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getRecipientNum() {
		return recipientNum;
	}
	public void setRecipientNum(String recipientNum) {
		this.recipientNum = recipientNum;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getMessageSentDate() {
		return messageSentDate;
	}
	public void setMessageSentDate(Date messageSentDate) {
		this.messageSentDate = messageSentDate;
	}
	public Boolean getIsSuccessfullySent() {
		return isSuccessfullySent;
	}
	public void setIsSuccessfullySent(Boolean isSuccessfullySent) {
		this.isSuccessfullySent = isSuccessfullySent;
	}
	
	
	
}
