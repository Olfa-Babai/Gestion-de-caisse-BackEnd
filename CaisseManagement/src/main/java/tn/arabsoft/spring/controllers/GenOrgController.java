package tn.arabsoft.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.spring.models.GenOrg;
import tn.arabsoft.spring.services.IGenOrgService;
import tn.arabsoft.spring.services.SequenceGeneratorService;

@CrossOrigin
@RestController
@RequestMapping("/org")
public class GenOrgController {
	
	@Autowired
	IGenOrgService genOrgService;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	@PostMapping("/add")
	@ResponseBody
	public GenOrg addOrg(@RequestBody GenOrg o){
		o.setOrg_id(sequenceGenerator.generateSequence(GenOrg.SEQUENCE_NAME));
		return this.genOrgService.addOrg(o);
	}

}
