package tn.arabsoft.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.arabsoft.spring.models.PayCashDeskSession;
import tn.arabsoft.spring.services.IPayCashDeskSessionService;
import tn.arabsoft.spring.services.SequenceGeneratorService;


@CrossOrigin
@RestController
@RequestMapping("/session")
public class PayCashDeskSessionController {
	
	@Autowired
	IPayCashDeskSessionService payCashDeskSessionService;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;
		
	@PostMapping("/add/{idagent}/{idd}/{idaff}")
	@ResponseBody
	public PayCashDeskSession add(@RequestBody PayCashDeskSession p, @PathVariable int idagent, @PathVariable int idd, @PathVariable int idaff){
		p.setCss_id(sequenceGenerator.generateSequence(PayCashDeskSession.SEQUENCE_NAME));
		return payCashDeskSessionService.add(p,idagent,idd,idaff);
	}
	
	@PutMapping("/end/{id}")
	@ResponseBody
	public PayCashDeskSession end_session(@PathVariable int id) {
		return this.payCashDeskSessionService.end_session(id);
	}
	
	@GetMapping("/getalltoday")
	@ResponseBody
	public List<PayCashDeskSession> allSessionsToday(){
		return this.payCashDeskSessionService.todaysSessions();
	}
	
	@GetMapping("/getall")
	@ResponseBody
	public List<PayCashDeskSession> allSessions() {
		return this.payCashDeskSessionService.allSessions();
	}
	
	@GetMapping("/gettodayencours")
	@ResponseBody
	public List<PayCashDeskSession> todayencours(){
		return this.payCashDeskSessionService.todayencours();
	}
	
	@GetMapping("/gettodayended")
	@ResponseBody
	public List<PayCashDeskSession> todayended(){
		return this.payCashDeskSessionService.todayended();
	}

}
