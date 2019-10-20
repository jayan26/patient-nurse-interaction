package com.abchospital.NPinteraction.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abchospital.NPinteraction.model.Patient;
import com.abchospital.NPinteraction.model.PatientRecord;
import com.abchospital.NPinteraction.repository.PatientRecordRepository;

@Service
public class PatientRecordService {

	@Autowired
	PatientRecordRepository patientRecordRepository;
	
	public PatientRecord createNewPatient(PatientRecord patientRecord) {
		System.out.println("Patient details in service: "+patientRecord.toString());
		return patientRecordRepository.save(patientRecord);
	}
	
	public PatientRecord updatePatient(PatientRecord patientRecord) {
		return patientRecordRepository.save(patientRecord);
	}
	
	public List<PatientRecord> getAllPatient(){
		return patientRecordRepository.findAll();
	}
	
	public Optional<PatientRecord> getPatientforID(Integer id) {
		return patientRecordRepository.findById(id);
	}
	
	public void deletePatient(Integer id) {
		patientRecordRepository.deleteById(id);
	}
	
	public PatientRecord getRecordbyUsername(String patientusername) {
		return patientRecordRepository.findByUsername(patientusername);
	}
	
}
