package tn.arabsoft.spring.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.spring.models.*;
import tn.arabsoft.spring.services.*;

@CrossOrigin
@RestController
@RequestMapping("/profile")
public class AdmProfileController {
	
	@Autowired
	IAdmProfileService admProfileService;
	
	@Autowired
	IAdmUserService admUserService;
	
	
	@PostMapping("/add")
	@ResponseBody
	public AdmProfile addProfile(@RequestBody AdmProfile profile, @RequestParam String matricule) {
		AdmUser user=this.admUserService.searchUser(matricule);
		profile.setPru_updtprudt(LocalDateTime.now());
		profile.setPru_label(matricule);
		return this.admProfileService.addProfile(profile, user);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public AdmProfile updateProfile(@RequestBody AdmProfile profile) {
		return this.admProfileService.updateProfile(profile, profile.getPru_id());
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteProfile(@PathVariable int id) {
		this.admProfileService.deleteProfile(id);
	}
	
	@GetMapping("all")
	@ResponseBody
	public List<AdmProfile> listProfiles() {
		return this.admProfileService.listProfiles();
	}
	
	@GetMapping("search/{id}")
	@ResponseBody
	public AdmProfile getProfileById(@PathVariable int id) {
		return this.admProfileService.getProfileById(id);
	}
	
}
