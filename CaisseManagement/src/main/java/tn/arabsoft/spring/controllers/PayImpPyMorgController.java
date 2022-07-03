package tn.arabsoft.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.spring.models.PayImpPyMorg;
import tn.arabsoft.spring.services.IPayImpPyMorgService;

@CrossOrigin
@RestController
@RequestMapping("/reglement")
public class PayImpPyMorgController {
	
	@Autowired
	IPayImpPyMorgService payImpService;
	
	@PostMapping("/add")
	@ResponseBody
	public PayImpPyMorg add(@RequestBody PayImpPyMorg p){
		return payImpService.add(p);
	}

}
