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


import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.services.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class AdmUserController {

	@Autowired
	IAdmUserService admUserService;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	@PostMapping("/add")
	@ResponseBody
	public AdmUser addUser(@RequestBody AdmUser user) {
		user.setUse_id( sequenceGenerator.generateSequence(AdmUser.SEQUENCE_NAME));
		user.setUse_crtdt(LocalDateTime.now());
		user.setUse_lastcnx(LocalDateTime.now());
		return this.admUserService.addUser(user);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public AdmUser updateUser(@RequestBody AdmUser user) {
		return this.admUserService.updateUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteUser(@PathVariable int id) {
		 admUserService.deleteUser(id);
	}
	
	@GetMapping("/all")
	@ResponseBody
	public List<AdmUser> allUsers() {
		return this.admUserService.listUsers();
	}	
	
	@GetMapping("/search")
	@ResponseBody
	public AdmUser searchUser(@RequestParam String matricule) {
		return this.admUserService.searchUser(matricule);
	}
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public AdmUser getUser(@PathVariable int id) {
		return this.admUserService.getUserById(id);
	}
	
	@GetMapping("/sort")
	@ResponseBody
	public List<AdmUser> sortUsers(@RequestParam String lf,@RequestParam String ad) {
		if(lf.equals("l")){
			if(ad.equals("a"))
			{
				return this.admUserService.listUsersSortedA();
			}
			else{
				return this.admUserService.listUsersSortedD();
			}
		}
		else {
			if(ad.equals("a"))
			{
				return this.admUserService.listUsersSortedAF();
			}
			else{
				return this.admUserService.listUsersSortedDF();
			}
		}
	}
	
	
	
}
