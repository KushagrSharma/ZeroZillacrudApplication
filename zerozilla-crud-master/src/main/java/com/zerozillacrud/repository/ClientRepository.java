package com.zerozillacrud.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.zerozillacrud.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
	
	@Transactional
	  @Modifying
	@Query(value = "UPDATE Client SET CLIENT_EMAIL= :clientEmail, CLIENT_NAME= :CLIENT_NAME,CLIENT_PHONE_NUMBER= :CLIENT_PHONE_NUMBER,TOTAL_BILL= :TOTAL_BILL WHERE CLIENT_ID= :CLIENT_ID AND AGENCY_ID= :AGENCY_ID")
	public int updateClientById(String clientEmail,String CLIENT_NAME,int CLIENT_PHONE_NUMBER, int TOTAL_BILL,long CLIENT_ID,long AGENCY_ID);
	
	@Query(value = "SELECT TOTAL_BILL FROM Client ORDER BY TOTAL_BILL DESC LIMIT 1", nativeQuery = true)
	public int getMaxTotalBill();
	
	@Query(value="SELECT CLIENT_NAME FROM Client WHERE TOTAL_BILL =?1", nativeQuery = true )
	public String getClientName(int totalBill);
	
	@Query(value="SELECT AGENCY_ID FROM Client WHERE CLIENT_NAME =?1", nativeQuery = true )
	public int getAgencyId(String clientname);
}
