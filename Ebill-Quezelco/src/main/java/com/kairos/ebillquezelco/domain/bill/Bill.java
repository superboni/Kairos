package com.kairos.ebillquezelco.domain.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tblBill")
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2357489923919785303L;

	// Fields
	@Id
	private String billId;
	private String accountNumber;
	private String oebrNumber;
	private BigInteger monthBilled;
	private Date startDate;
	private Date endDate;
	private BigDecimal currentReading;
	private BigDecimal previousReading;
	private String billStatus;
	private Date billPrintDate;
	private Boolean latePaymentChargeSw;
	private Date latePaymentChargeDate;
	private BigDecimal currentBillAmount;
	
	public String getBillId() {
		return billId;
	}
	
	public void setBillId(String billId) {
		this.billId = billId;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getOebrNumber() {
		return oebrNumber;
	}
	
	public void setOebrNumber(String oebrNumber) {
		this.oebrNumber = oebrNumber;
	}
	
	public BigInteger getMonthBilled() {
		return monthBilled;
	}
	
	public void setMonthBilled(BigInteger month) {
		this.monthBilled = month;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public BigDecimal getCurrentReading() {
		return currentReading;
	}
	public void setCurrentReading(BigDecimal currentReading) {
		this.currentReading = currentReading;
	}
	public BigDecimal getPreviousReading() {
		return previousReading;
	}
	public void setPreviousReading(BigDecimal previousReading) {
		this.previousReading = previousReading;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	public Date getBillPrintDate() {
		return billPrintDate;
	}
	public void setBillPrintDate(Date billPrintDate) {
		this.billPrintDate = billPrintDate;
	}
	public Boolean getLatePaymentChargeSw() {
		return latePaymentChargeSw;
	}
	public void setLatePaymentChargeSw(Boolean latePaymentChargeSw) {
		this.latePaymentChargeSw = latePaymentChargeSw;
	}
	public Date getLatePaymentChargeDate() {
		return latePaymentChargeDate;
	}
	public void setLatePaymentChargeDate(Date latePaymentChargeDate) {
		this.latePaymentChargeDate = latePaymentChargeDate;
	}

	public BigDecimal getCurrentBillAmount() {
		return currentBillAmount;
	}

	public void setCurrentBillAmount(BigDecimal currentBillAmount) {
		this.currentBillAmount = currentBillAmount;
	}
}
