package com.abchospital.NPinteraction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abchospital.NPinteraction.model.Nurse;
import com.abchospital.NPinteraction.repository.NurseRepository;

@Service
public class NurseService {

	@Autowired
	public NurseRepository nurseRepository;
	
	public Nurse createNurseDetails(Nurse nurse) {
		nurse.setUsername("N-"+nurse.getUsername());
		return nurseRepository.save(nurse);
	}
	
	public Nurse updateNurseDetails(Nurse nurse) {
		return nurseRepository.save(nurse);
	}
	
	public List<Nurse> getAllNurseDetails(){
		return nurseRepository.findAll();
	}
	
	public Optional<Nurse> getNursebyID(String id) {
		return nurseRepository.findById(id);
	}
	
	public void deleteNurse(String id) {
		nurseRepository.deleteById(id);
	}
	
}
