package com.abchospital.NPinteraction.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.abchospital.NPinteraction.Utils.PatientControllerHelper;
import com.abchospital.NPinteraction.model.BufferModel;
import com.abchospital.NPinteraction.model.LoginCredentials;
import com.abchospital.NPinteraction.model.Patient;
import com.abchospital.NPinteraction.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private PatientService patientserv;
	
	@Autowired
	private PatientControllerHelper patientControllerHelper;
	
	@RequestMapping("/")
	public String patientLogin(LoginCredentials loginCredentials) {
		return "PatientLogin";
	}
	
	
	@RequestMapping("/patientLoginProcess")
	public String patientLoginProcess(LoginCredentials loginCredentials, Error error, ModelMap modelMap, HttpSession session) {
		if(patientControllerHelper.loginCheck(loginCredentials)) {
			modelMap.addAttribute("message", "Welcome!");
			session.setAttribute("patientUsername", loginCredentials.getUsername());
			modelMap.addAttribute("buffer", new BufferModel());
			return "Welcome";
			}
		modelMap.addAttribute("credentialsError", "Please check Login Credentials");
		return "PatientLogin";
	}
	
	
	@RequestMapping("/register")
	public String patientRegister(Patient patient, ModelMap modelMap, BufferModel bufferModel) {
		return "PatientRegister";
	}
	
	
	@RequestMapping("/registerPatient")
	public String createPatient(Patient patient, Errors errors, ModelMap modelMap, BufferModel bufferModel) {
		if(patientControllerHelper.isUsernameExist(patient)) {
			modelMap.addAttribute("errorMsg", "Username already Exists!");
			modelMap.addAttribute("patient", patient);
			modelMap.addAttribute("passwordConfirmation", bufferModel);
			return "PatientRegister";
		}else if(!bufferModel.getBufferValue().equals(patient.getPassword())){
			modelMap.addAttribute("errorMsg", "Passwords did not match!");
			modelMap.addAttribute("patient", patient);
			return "PatientRegister";
		}
		patientserv.createNewPatient(patient);
		modelMap.addAttribute("message", "Profile successfuly created!	Your username is "+patient.getUsername());
		modelMap.addAttribute("loginCredentials", new LoginCredentials());
		return "PatientLogin";
	}
	
	
	@RequestMapping("/testpage")
	public String testpage(HttpSession session, BufferModel buffer, Error error, ModelMap modelMap) {
		
		System.out.println("session value inside testpage(patient): "+session.getAttribute("patientUsername"));
		System.out.println("session value inside testpage(nurse): "+session.getAttribute("nurseUsername"));
		System.out.println("Buffer value inside testpage: "+ buffer.getBufferValue());
		
		modelMap.addAttribute("loginCredentials", new LoginCredentials());
		modelMap.addAttribute("session", session);
		return "PatientLogin";
	}
	
//	@GetMapping(value="/getall")
//	public String getallPatientDetails(ModelMap modelMap) {
//		List<Patient> allPatients = patientserv.getAllPatient();
//		modelMap.addAttribute(allPatients);
//		return "ViewAllPatients";
//	}
	
	
//	@GetMapping(value="/getbyid/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
//	public Optional<Patient> getPatientbyID(@PathVariable("id") Integer id) {
//		System.out.println("This is ID: "+id);
//		return patientserv.getPatientforID(id);
//	}
	
}
