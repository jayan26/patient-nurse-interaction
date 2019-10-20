package com.abchospital.NPinteraction.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abchospital.NPinteraction.model.BufferModel;
import com.abchospital.NPinteraction.model.PatientRecord;
import com.abchospital.NPinteraction.service.PatientRecordService;

@Controller
@RequestMapping("/general")
public class ActionController {
	
	@Autowired
	PatientRecordService patientRecordService;

	@RequestMapping(value = "/", params="action=view")
	public String viewPatientDetails(BufferModel buffer, Error error, ModelMap modelMap ) {
		System.out.println("I'm in view Patient Details inside genral controller");
		System.out.println("value in buffer - general controller: "+buffer.getBufferValue());
		//modelMap.addAttribute("patientRecord", patientRecordService.getRecordbyUsername(buffer.getBufferValue()));
		modelMap.addAttribute("patientRecord",patientRecordService.getRecordbyUsername(buffer.getBufferValue()));
		return "ViewRecordPage";
	}
	
	@RequestMapping(value = "/", params="action=edit")
	public String editPatientDetails(BufferModel buffer, Error error, ModelMap modelMap ) {
		System.out.println("I'm in view Patient Details inside genral controller");
		System.out.println("value in buffer - general controller: "+buffer.getBufferValue());
		return "testPage";
	}
	
	@RequestMapping(value = "/", params="action=create")
	public String createPatientoption(BufferModel buffer, Error error, ModelMap modelMap ) {
		modelMap.addAttribute("patientRecord", new PatientRecord());
		return "CreatePatientRecord";
	}
	
	@RequestMapping(value = "/createRecord")
	public String createPatientRecord(PatientRecord patientRecord, Error error, ModelMap modelMap ) {
		patientRecord.setCreated_date((new Date().toString()));
		patientRecordService.createNewPatient(patientRecord);
		modelMap.addAttribute("message", "Successfully created record for "+patientRecord.getPatientusername());
		return "CreatePatientRecord";
	}
	
}
