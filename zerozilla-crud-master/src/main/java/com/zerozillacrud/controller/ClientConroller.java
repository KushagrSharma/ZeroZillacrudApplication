package com.zerozillacrud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerozillacrud.exception.ResourceNotFoundException;
import com.zerozillacrud.model.AgencyClient;
import com.zerozillacrud.model.Client;
import com.zerozillacrud.model.MaxClient;
import com.zerozillacrud.repository.AgencyRepository;
import com.zerozillacrud.repository.ClientRepository;

@RestController
@RequestMapping("/api")
public class ClientConroller {

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	AgencyRepository agencyRepository;
	
	Client clientUpdate;
	@PutMapping("/upadteClient/{clientid}")
	public ResponseEntity<?> updateClientDetails(@Valid @PathVariable("clientid") long clientid, @RequestBody AgencyClient updateClient) throws ResourceNotFoundException{
		Client client = clientRepository.findById(clientid).
				orElseThrow(() -> new ResourceNotFoundException("Update Client Failed!! no client present with client id "+clientid));
		 int updated= clientRepository.updateClientById(updateClient.getClientEmail(),updateClient.getClientName(), updateClient.getClientPhone(), updateClient.getTotalBill(), clientid, updateClient.getAgencyId());
		//return client;
			if(updated==1) {
			return new ResponseEntity<>(client, HttpStatus.OK);
			}
			else
				return new ResponseEntity<>("Update client failed for client id "+clientid, HttpStatus.BAD_REQUEST);
	}
	
	MaxClient maxClient= new MaxClient();
	@GetMapping("/getMaxClient")
	public ResponseEntity<MaxClient> findMaxClient(){
		MaxClient maxClient= new MaxClient();
		try {
			
//			MaxClient maxClient=null;
//			maxClient.setTotalBill(clientRepository.getMaxTotalBill());
//			maxClient.setClientName(clientRepository.getClientName(clientRepository.getMaxTotalBill()));
//			System.out.println("Value of Total Bill is "+ clientRepository.getMaxTotalBill() + "Value of Client Name is " + clientRepository.getMaxTotalBill());
			
			
			
			maxClient.setTotalBill(clientRepository.getMaxTotalBill());
			maxClient.setClientName(clientRepository.getClientName(clientRepository.getMaxTotalBill()));
			int agencyId = clientRepository.getAgencyId(maxClient.getClientName());
			maxClient.setAgencyName(agencyRepository.getAgencyName(agencyId));
			System.out.println("Total Amount is "+maxClient.getTotalBill() + "Client Name is "+maxClient.getClientName() + "Agency Id is "+agencyId + "Agency Name is "+maxClient.getAgencyName());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return new ResponseEntity(maxClient, HttpStatus.OK);
	}
}
