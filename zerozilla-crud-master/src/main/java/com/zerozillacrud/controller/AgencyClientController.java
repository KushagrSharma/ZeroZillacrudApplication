package com.zerozillacrud.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zerozillacrud.exception.ResourceNotFoundException;
import com.zerozillacrud.model.Agency;
import com.zerozillacrud.model.AgencyClient;
import com.zerozillacrud.model.Client;
import com.zerozillacrud.repository.AgencyRepository;
import com.zerozillacrud.repository.ClientRepository;

@RestController
@CrossOrigin(origins="http://localhost:8080")
@RequestMapping("/add")
public class AgencyClientController {
	
	@Autowired
	AgencyRepository agencyRepo;
	
	@Autowired
	ClientRepository clientRepo;
	
	Agency agency;
	Client client;
	
	@PostMapping("clientoragency")
	public ResponseEntity<?> addAgencyOrClient(@Valid @RequestBody AgencyClient agencyClient){
		try {
			if(agencyClient.getAgencyId()==0) {
				agency = addAgency(agencyClient);
			}
			
			if(agencyClient.getAgencyId()!=0) {
				//create only client with existing agency
					checkIfAgencyIdPresent(agencyClient.getAgencyId());
				client=addClientWithAgencyIdInRequest(agencyClient);
			}
			if(agency.getAgencyId()!=0 & agencyClient.getAgencyId()==0) {
				client=addCleintWithAgencyId(agencyClient,agency.getAgencyId());
		}
			
		}catch(Exception e) {
			return new ResponseEntity<>(new ResourceNotFoundException("Please provide valid request").getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("Data Created Success", HttpStatus.OK);
	}
	
	public Agency addAgency(AgencyClient agencyCreateRequest) {
		Agency agency= agencyRepo.save(new Agency(agencyCreateRequest.getAgencyName(), agencyCreateRequest.getAddress1(), agencyCreateRequest.getAddress2(), 
				agencyCreateRequest.getState(), agencyCreateRequest.getCity(), agencyCreateRequest.getPhoneNumber()));
		return agency;
	}
	
	public Agency checkIfAgencyIdPresent(long agencyId) throws ResourceNotFoundException {
		return agencyRepo.findById(agencyId).orElseThrow(() ->
		new ResourceNotFoundException("Client Creation failed as given Agent Id "+agencyId +" does not exist!. Please try again with valid agency id."));
	}
	
	public Client addClientWithAgencyIdInRequest(AgencyClient clientCreateRequest) {
		Client client = clientRepo.save(new Client(clientCreateRequest.getAgencyId(), clientCreateRequest.getClientName(), clientCreateRequest.getClientEmail(),
				clientCreateRequest.getTotalBill(), clientCreateRequest.getClientPhone()));
		return client;
	}
	public Client addCleintWithAgencyId(AgencyClient clientCreateRequest, long agencyId) {
		Client client = clientRepo.save(new Client(agencyId, clientCreateRequest.getClientEmail(), clientCreateRequest.getClientEmail(),
				clientCreateRequest.getClientPhone(), clientCreateRequest.getTotalBill()));
		return client;
	}
	
}