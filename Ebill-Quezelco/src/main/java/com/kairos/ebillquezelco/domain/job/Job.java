package com.kairos.ebillquezelco.domain.job;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblJob")
public class Job implements Serializable {

	private static final long serialVersionUID = 3375897970338754891L;
	
	// Fields
	@Id
	@GeneratedValue
	private Long jobId;
	
	private String jobType;
	public Date getStartBillDate() {
		return startBillDate;
	}
	public void setStartBillDate(Date startBillDate) {
		this.startBillDate = startBillDate;
	}
	public Date getEndBillDate() {
		return endBillDate;
	}
	public void setEndBillDate(Date endBillDate) {
		this.endBillDate = endBillDate;
	}
	private Date startBillDate;
	private Date endBillDate;
	private String jobStatus;
	private Date startRunDateTime;
	private Date endRunDateTime;
	public Long getJobId() {
		return jobId;
	}
	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public Date getStartRunDateTime() {
		return startRunDateTime;
	}
	public void setStartRunDateTime(Date startRunDateTime) {
		this.startRunDateTime = startRunDateTime;
	}
	public Date getEndRunDateTime() {
		return endRunDateTime;
	}
	public void setEndRunDateTime(Date endRunDateTime) {
		this.endRunDateTime = endRunDateTime;
	}
	
	
}
