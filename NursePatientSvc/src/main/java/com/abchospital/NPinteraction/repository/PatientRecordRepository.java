package com.abchospital.NPinteraction.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.abchospital.NPinteraction.model.PatientRecord;

@Repository
public interface PatientRecordRepository extends CrudRepository<PatientRecord, Integer>{
	
	@Override
    List<PatientRecord> findAll();
	
	@Query(value = "select * from patientrecords where patientusername = ?1", nativeQuery = true)
	  PatientRecord findByUsername(String patientusername);
	
	
}
