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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.arabsoft.spring.models.PayCashDesk;
import tn.arabsoft.spring.services.IPayCashDeskService;
import tn.arabsoft.spring.services.SequenceGeneratorService;

@CrossOrigin
@RestController
@RequestMapping("/caisse")
public class PayCashDeskController {

	@Autowired
	IPayCashDeskService payService;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	@PostMapping("/add")
	@ResponseBody
	public PayCashDesk addCaisse(@RequestBody PayCashDesk c, @RequestParam int[] ids){
		c.setCah_id(sequenceGenerator.generateSequence(PayCashDesk.SEQUENCE_NAME));
		return payService.addCaisse(c, ids);
	}
	
	// update
	
	@PutMapping("/update")
	@ResponseBody
	public PayCashDesk updateCaisse(@RequestBody PayCashDesk c){
		return payService.updateCaisse(c);
	}
	// get one
	@GetMapping("/get/{id}")
	@ResponseBody
	public PayCashDesk getCaisse(@PathVariable int id){
		return payService.getCaisse(id);
	}
	// get all
	@GetMapping("/getAll")
	@ResponseBody
	public List<PayCashDesk> getAllCaisse(){
		return payService.getAllCaisse();
	}
	// delete
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public void deleteCaisse(@PathVariable int id){
		 payService.deleteCaisse(id);
	}
}
