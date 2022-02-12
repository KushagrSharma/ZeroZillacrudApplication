package com.zerozillacrud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue
	private long clientId;
	
	@NotNull
	private long agencyId;
	
	@NotNull
	private String clientName;
	
	@NotNull
	@Email
	private String clientEmail;

	@NotNull
	private int clientPhoneNumber;
	
	@NotNull
	private int totalBill;

	public Client(@NotNull long agencyId, @NotNull String clientName, @NotNull @Email String clientEmail,
			@NotNull int clientPhoneNumber, @NotNull int totalBill) {
		super();
		this.agencyId = agencyId;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		this.clientPhoneNumber = clientPhoneNumber;
		this.totalBill = totalBill;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(long agencyId) {
		this.agencyId = agencyId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public int getClientPhoneNumber() {
		return clientPhoneNumber;
	}

	public void setClientPhoneNumber(int clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}

	public int getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	public Client() {
	}

}
