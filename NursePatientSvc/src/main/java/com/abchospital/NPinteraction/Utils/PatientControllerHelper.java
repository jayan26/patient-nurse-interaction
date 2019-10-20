package com.abchospital.NPinteraction.Utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abchospital.NPinteraction.model.LoginCredentials;
import com.abchospital.NPinteraction.model.Patient;
import com.abchospital.NPinteraction.service.PatientService;

@Component
public class PatientControllerHelper {

	private List<Patient> allPatients = null;
	
	@Autowired
	public PatientService patientService;
	
	public boolean loginCheck(LoginCredentials loginCredentials) {
		allPatients = patientService.getAllPatient();
		for (Patient patient : allPatients) {
			if(patient.getUsername().equals(loginCredentials.getUsername()) && patient.getPassword().equals(loginCredentials.getPassword())) {return true;}
		}return false;
	}
	
	
	public boolean isUsernameExist(Patient patient) {
		allPatients = patientService.getAllPatient();
		for (Patient patient2 : allPatients) {
			System.out.println(patient2.getUsername());
			System.out.println(patient.getUsername());
			if(patient2.getUsername().equals(patient.getUsername())) {return true;}
		}return false;
	}
	
}
