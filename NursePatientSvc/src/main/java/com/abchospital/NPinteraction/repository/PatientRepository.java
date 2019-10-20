package com.abchospital.NPinteraction.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abchospital.NPinteraction.model.Patient;

@Repository
public interface PatientRepository extends CrudRepository<Patient, String>{

	@Override
    List<Patient> findAll();
	
}
