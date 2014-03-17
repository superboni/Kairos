package com.kairos.ebillquezelco.domain.bill;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="tblBill")
public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2357489923919785303L;

	// Fields
	@Id
	@GeneratedValue
	private Long id;
	
	private String accountNumber;
	private String oebrNumber;
	private BigInteger monthBilled;
	
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date startDate;
	
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date endDate;
	private BigDecimal currentKwh;
	private BigDecimal currentReading;
	private BigDecimal previousReading;
	private String billStatus;
	private Date billPrintDate;
	private Date latePaymentChargeDate;
	private BigDecimal currentBillAmount;
	
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

	public BigDecimal getCurrentKwh() {
		return currentKwh;
	}

	public void setCurrentKwh(BigDecimal currentKwh) {
		this.currentKwh = currentKwh;
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}
}
