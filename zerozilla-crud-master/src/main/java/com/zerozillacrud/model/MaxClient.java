package com.zerozillacrud.model;

import javax.persistence.Entity;


public class MaxClient {
	
	private String agencyName;
	private String clientName;
	private int totalbill;
	public String getAgencyName() {
		return agencyName;
	}
	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public int getTotalBill() {
		return totalbill;
	}
	public void setTotalBill(int totalbill) {
		this.totalbill = totalbill;
	}
	public MaxClient() {
		super();
	}
	public MaxClient(String agencyName, String clientName, int totalbill) {
		super();
		this.agencyName = agencyName;
		this.clientName = clientName;
		this.totalbill = totalbill;
	}
//	@Override
//	public String toString() {
//		return "MaxClient [agencyName=" + agencyName + ", clientName=" + clientName + ", totalBill=" + totalbill + "]";
//	}
//	
	

}
