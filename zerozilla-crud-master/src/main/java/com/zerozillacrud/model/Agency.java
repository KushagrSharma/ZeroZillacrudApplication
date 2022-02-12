package com.zerozillacrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "agency")
public class Agency {
	
	public Agency(@NotNull @Size(min = 2, message = "First Name should have atleast 2 characters") String agencyName,
			@NotNull String agencyAddress1, String agencyAddress2, @NotNull String state, @NotNull String city,
			@NotNull int phoneNumber) {
		super();
		this.agencyName = agencyName;
		this.agencyAddress1 = agencyAddress1;
		this.agencyAddress2 = agencyAddress2;
		this.state = state;
		this.city = city;
		this.phoneNumber = phoneNumber;
	}

	public long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(long agencyId) {
		this.agencyId = agencyId;
	}

	public String getAgencyName() {
		return agencyName;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public String getAgencyAddress1() {
		return agencyAddress1;
	}

	public void setAgencyAddress1(String agencyAddress1) {
		this.agencyAddress1 = agencyAddress1;
	}

	public String getAgencyAddress2() {
		return agencyAddress2;
	}

	public void setAgencyAddress2(String agencyAddress2) {
		this.agencyAddress2 = agencyAddress2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Id
	@GeneratedValue
	private long agencyId;
	 
    @NotNull (message="First Name cannot be null")
    @Size(min = 2, message = "First Name should have atleast 2 characters")
    private String agencyName;
 
    @NotNull
    private String agencyAddress1;
    
    private String agencyAddress2;
    
    @NotNull
    private String state;
    
    @NotNull
    private String city;
 
    @NotNull
    private int phoneNumber;

	public Agency() {

	}

	
}
