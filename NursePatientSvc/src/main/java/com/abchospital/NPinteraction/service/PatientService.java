package com.abchospital.NPinteraction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abchospital.NPinteraction.model.Patient;
import com.abchospital.NPinteraction.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientrepo;
	
	public Patient createNewPatient(Patient patient) {
		patient.setUsername("P-"+patient.getUsername());
		return patientrepo.save(patient);
	}
	
	public Patient updatePatient(Patient patient) {
		return patientrepo.save(patient);
	}
	
	public List<Patient> getAllPatient(){
		return patientrepo.findAll();
	}
	
	public Optional<Patient> getPatientforID(String id) {
		return patientrepo.findById(id);
	}
	
	public void deletePatient(String id) {
		patientrepo.deleteById(id);
	}
	
}
