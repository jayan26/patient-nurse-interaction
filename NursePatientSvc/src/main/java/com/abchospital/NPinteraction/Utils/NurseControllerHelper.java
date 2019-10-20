package com.abchospital.NPinteraction.Utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abchospital.NPinteraction.model.LoginCredentials;
import com.abchospital.NPinteraction.model.Nurse;
import com.abchospital.NPinteraction.service.NurseService;

@Component
public class NurseControllerHelper {

	@Autowired
	public NurseService nurseService;
	
	List<Nurse> allNurse;
	
	public boolean loginCheck(LoginCredentials loginCredentials) {
		allNurse = nurseService.getAllNurseDetails();
		for (Nurse nurse : allNurse) {
			System.out.println("nurse username:"+nurse.getUsername());
			System.out.println("credential username: "+ loginCredentials.getUsername());
			if(nurse.getUsername().equals(loginCredentials.getUsername()) && nurse.getPassword().equals(loginCredentials.getPassword())) {return true;}
		}return false;
	}
	
	public boolean isUsernameExist(Nurse nurse) {
		allNurse = nurseService.getAllNurseDetails();
		for (Nurse nurse2 : allNurse) {
			System.out.println(nurse2.getUsername());
			System.out.println(nurse.getUsername());
			if(nurse2.getUsername().equals(nurse.getUsername())) {return true;}
		}return false;
	}
	
}
