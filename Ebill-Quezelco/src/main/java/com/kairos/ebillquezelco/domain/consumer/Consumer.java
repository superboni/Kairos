package com.kairos.ebillquezelco.domain.consumer;

import java.io.Serializable;

import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Consumer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3022511463341776717L;
	
	// Fields
	private String accountNumber;
	
	private String oebrNbr;
	
	@NotEmpty
	@Size(max=70)
	private String firstName;
	
	@Size(max=70)
	private String middleName;
	
	@NotEmpty
	@Size(max=70)
	private String lastName;

	@Transient
	private String fullName;
	
	private String address;
	
	private String phoneNumber;
	
	private String mobileNumber;
	
	private Boolean isSmsSubscribed;

	private String status;	
	
	private String customerType;
	
	
	// Setters
	public void setAcctNbr (String acctNbr) {
		this.accountNumber = acctNbr;
	}
	
	public void setOebrNumber (String oebrNbr) {
		this.oebrNbr = oebrNbr;
	}
	
	public void setFirstName (String firstName) {
		this.firstName = firstName;
	}
	
	public void setMiddleName (String middleName) {
		this.middleName = middleName;
	}
	
	public void setLastName (String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setPhoneNumber (String phoneNbr) {
		this.phoneNumber = phoneNbr;
	}
	
	public void setMobileNumber (String mobileNbr) {
		this.mobileNumber = mobileNbr;
	}
	
	public void setSmsSubscription (Boolean smsSubscription) {
		this.isSmsSubscribed = smsSubscription;
	}
	
	public void setStatus (String status) {
		this.status = status;
	}
	
	public void setCustomerType (String customerType) {
		this.customerType = customerType;
	}
	
	// Getters
	public String getAcctNbr () {
		return accountNumber;
	}
	
	public String getOebrNumber () {
		return oebrNbr;
	}
	
	public String getFirstName () {
		return firstName;
	}
	
	public String getLastName () {
		return lastName;
	}
	
	public String getAddress () {
		return address;
	}
	
	public String getPhoneNumber () {
		return phoneNumber;
	}
	
	public String getMobileNumber () {
		return mobileNumber;
	}
	
	public Boolean getSmsSubscription () {
		return isSmsSubscribed;
	}
	
	public String getStatus () {
		return status;
	}
	
	public String getCustomerType () {
		return customerType;
	}
	
	public String getFullName() {
		return fullName = !(middleName==null || "".equals(middleName))
						? firstName + " " + middleName.substring(0, 1) + ". " + lastName 
						: firstName + " " + lastName;
	}
}
