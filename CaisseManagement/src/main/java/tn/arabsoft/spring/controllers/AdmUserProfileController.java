package tn.arabsoft.spring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.spring.models.*;
import tn.arabsoft.spring.services.*;

@CrossOrigin
@RestController
@RequestMapping("/userprofile")
public class AdmUserProfileController {

	@Autowired
	IAdmUserProfileService admUserProfileService;
	
	@PostMapping("/add/{idp}/{idu}")
	@ResponseBody
	public AdmUserProfile addUserProfile(@PathVariable int idp, @PathVariable int idu) {
		return this.admUserProfileService.addAffUP(idp, idu);
	}

}
