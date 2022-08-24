package io.getarrays.userservice.api;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.getarrays.userservice.domain.GenAccount;
import io.getarrays.userservice.domain.GenAgent;
import io.getarrays.userservice.domain.GenDebt;
import io.getarrays.userservice.domain.GenOrg;
import io.getarrays.userservice.domain.Party;
import io.getarrays.userservice.domain.PayCashDesk;
import io.getarrays.userservice.domain.PayCashDeskSession;
import io.getarrays.userservice.domain.PayImpPyMorg;
import io.getarrays.userservice.service.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins="*")
public class GenDebtRessource {

	private final  GenDebtService genDebt;
	
	@GetMapping("/user/caisse/all")
	public List<PayCashDesk> getAllCaisses(){
		return genDebt.getAllCaisses();
	}
	
	@GetMapping("/user/caisse/modes/{id}")
	public List<PayImpPyMorg> getModesReglements(@PathVariable Long id){
		return this.genDebt.getModesReglements(id);
	}
	
	// get all clients : 
	@GetMapping("/user/clients")
	public List<Party> getAllClients(){
		return this.genDebt.getAllParties();
	}	
	
	// get all client's accounts :
	
	@GetMapping("/user/client/account/all/{id}")
	public List<GenAccount> getAllClientAccounts(@PathVariable Long id){
		return this.genDebt.getAllClientAccounts(id);
	}
	
	// encaissement des factures
	
	// lister les factures
	@GetMapping("/user/debt/all")
	public List<GenDebt> getAllFactures(){
		return this.genDebt.getAllFactures();
	}
	
	//get factures of a client : 
	@GetMapping("/user/client/debts/{id}")
	public List<GenDebt> getClientsFactures(@PathVariable Long id){
		return this.genDebt.getClientsFactures(id);
	}
	
	//recherche
	@GetMapping("/user/debt/search")
	public GenDebt getFacture(@RequestParam String ref){
		return this.genDebt.SearchFacture(ref);
	}
	
	// get client by facture
	@GetMapping("/user/client/fact")
	public Party getClientFact(@RequestBody GenDebt genDebt){
		return this.genDebt.getClientFact(genDebt);
	}
	
	//get by id
	@GetMapping("/user/debt/{id}")
	public GenDebt getGenDebt(@PathVariable Long id){
		return this.genDebt.getDebtById(id);
	}
	
	@GetMapping("/user/org/all")
	public List<GenOrg> getAllOrgs(){
		return this.genDebt.getAllOrgs();
	}
	
	//ouvrir session
	@PostMapping("/user/session/open/{id}")
	public PayCashDeskSession openSession(@RequestParam String login, @PathVariable Long id){
		return this.genDebt.ouvrirSession(login, id);
	}
	
	@PutMapping("/user/session/close/{id}")
	public PayCashDeskSession closeSession(@PathVariable Long id){
		return this.genDebt.fermerSession(id);
	}
	
	@GetMapping("/user/session/check")
	public PayCashDeskSession checkLastSession(){
		return this.genDebt.checkSession();
	}
	
	@GetMapping("/user/agent")
	public GenAgent getTheAgent(@RequestParam String login){
		return this.genDebt.getAgent(login);
	}
	
}
