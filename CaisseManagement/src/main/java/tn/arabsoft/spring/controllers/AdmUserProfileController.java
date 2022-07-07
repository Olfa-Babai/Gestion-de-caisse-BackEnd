package tn.arabsoft.spring.controllers;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.DocumentException;

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
	
	@GetMapping("/get")
	@ResponseBody
	public Map<AdmUser, List<AdmProfile>> organizing(){
		return this.admUserProfileService.organizing();
	}
	
	@GetMapping("/pdf")
	@ResponseBody
	public void savetoPdf() throws FileNotFoundException, DocumentException{
		this.admUserProfileService.savetoPdf();
	}
	
	@GetMapping("/extract/")
	@ResponseBody
	public Map<AdmUser, List<AdmProfile>> extract(@RequestParam String type){
		return admUserProfileService.extract(type);
	}
	
	@GetMapping("/searching/")
	@ResponseBody
	public Map<AdmUser, List<AdmProfile>> searching(String word){
		return this.admUserProfileService.searching(word);
		}

}
