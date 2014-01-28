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
	// Getters
	// Setters
	// Other logics for consumer

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

	private Boolean isActive;	
	
}
