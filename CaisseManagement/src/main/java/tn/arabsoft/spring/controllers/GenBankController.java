package tn.arabsoft.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.spring.models.GenBank;
import tn.arabsoft.spring.services.IGenBankService;

@CrossOrigin
@RestController
@RequestMapping("/bank")
public class GenBankController {

	@Autowired
	IGenBankService genbankS;
	
	@PostMapping("/add")
	@ResponseBody
	public GenBank ajoutBank(@RequestBody GenBank b) {
		return this.genbankS.ajoutBank(b);
	}
	
}
