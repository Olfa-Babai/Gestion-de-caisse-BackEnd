package tn.arabsoft.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import tn.arabsoft.spring.services.IAdmUserService;
import tn.arabsoft.spring.services.SequenceGeneratorService;

@Controller
public class AdmProfileController {


	@Autowired
	IAdmUserService admUserService;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
}
