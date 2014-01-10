package com.kairos.ebillquezelco.domain.extras;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * <p> A basic announcements publishing module </p>
 * 
 * @author jpbonifacio
 *
 */
@Entity
@Table(name="tblAnnouncement")
public class Announcement implements Serializable {

	private static final long serialVersionUID = 3205790203838757419L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@NotEmpty
	@Size(max=2000)
	private String text;
	
	@NotNull
	@NotEmpty
	private Date startDate;
	
	@NotNull
	@NotEmpty
	private Date endDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	@Override
	public String toString() {
		return "Announcement: " +
				String.valueOf(id) + " " +
				this.text + " " +
				this.startDate.toString() + " " +
				this.endDate.toString() + " ";
	}

}
