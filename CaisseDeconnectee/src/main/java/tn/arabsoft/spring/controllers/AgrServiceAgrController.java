package tn.arabsoft.spring.controllers;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.spring.models.AgrServiceAgr;
import tn.arabsoft.spring.services.*;

@CrossOrigin
@RestController
@RequestMapping("/contrat")
public class AgrServiceAgrController {

	@Autowired
	IAgrServiceAgrService contratService;
	
	@PostMapping("/add")
	@ResponseBody
	public AgrServiceAgr ajoutContrat(@RequestBody AgrServiceAgr a){
		return this.contratService.addContrat(a);
	}
	
	@PutMapping("/update")
	@ResponseBody
	public AgrServiceAgr majContrat(@RequestBody AgrServiceAgr a){
		return this.contratService.updateContrat(a);
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteContrat(@PathVariable int id){
		this.contratService.deleteContrat(id);
	}
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public void getContrat(@PathVariable int id){
		this.contratService.getById(id);
	}
	
	@GetMapping("/getall")
	@ResponseBody
	public List<AgrServiceAgr> getAllContrats(){
		return this.contratService.all();
	}
	
}
