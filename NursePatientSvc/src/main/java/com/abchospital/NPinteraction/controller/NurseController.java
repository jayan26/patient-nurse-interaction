package com.abchospital.NPinteraction.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abchospital.NPinteraction.Utils.NurseControllerHelper;
import com.abchospital.NPinteraction.model.BufferModel;
import com.abchospital.NPinteraction.model.LoginCredentials;

@Controller
@RequestMapping("/nurse")
public class NurseController {

	@Autowired
	public NurseControllerHelper NurseControllerHelper;
	
	@RequestMapping("/")
	public String nurseLogin(LoginCredentials loginCredentials) {
		return "NurseLogin";
	}
	
	@RequestMapping("/nurseLoginProcess")
	public String nurseLoginProcess(LoginCredentials loginCredentials, Error error, ModelMap modelMap, HttpSession session) {
		if(NurseControllerHelper.loginCheck(loginCredentials)) {
			modelMap.addAttribute("message", "Welcome!");
			session.setAttribute("nurseUsername", loginCredentials.getUsername());
			modelMap.addAttribute("buffer", new BufferModel());
			return "Welcome";
			}
		modelMap.addAttribute("credentialsError", "Please check Login Credentials");
		return "NurseLogin";
	}
	
	@RequestMapping("/welcome")
	public String welcomePage(Error error, ModelMap modelMap, HttpSession session) {
		session.setAttribute("session", session);
		modelMap.addAttribute("buffer", new BufferModel());
		return "Welcome";
	}
	
}
