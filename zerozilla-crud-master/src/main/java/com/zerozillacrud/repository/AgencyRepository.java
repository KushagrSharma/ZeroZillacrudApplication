package com.zerozillacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zerozillacrud.model.Agency;

@Repository
public interface AgencyRepository extends JpaRepository<Agency, Long>{
	@Query(value="SELECT AGENCY_NAME FROM AGENCY WHERE AGENCY_ID =?1", nativeQuery = true )
	public String getAgencyName(int agencyid);
}
