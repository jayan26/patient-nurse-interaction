package com.abchospital.NPinteraction.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.abchospital.NPinteraction.model.Nurse;
import com.abchospital.NPinteraction.model.Patient;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, String>{

	@Override
    List<Nurse> findAll();
	
}
