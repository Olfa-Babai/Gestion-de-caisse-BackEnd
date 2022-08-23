package io.getarrays.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.getarrays.userservice.domain.GenAccount;
import io.getarrays.userservice.domain.GenDebt;
import io.getarrays.userservice.domain.GenOrg;
import io.getarrays.userservice.domain.Party;
import io.getarrays.userservice.domain.PayCashDesk;
import io.getarrays.userservice.domain.PayImpPyMorg;
import io.getarrays.userservice.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class GenDebtServiceImpl implements GenDebtService {
	
	private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final GenAgentRepo agentRepo;
    private final UserProfileRepo userPRepo;
    private final PaycashDeskRepo caisseRepo;
    private final PartyRepo partyRepo;
    private final GenDebtRepo genDebtRepo;
    private final GenOrgRepo genOrgRepo;
    
	// lister les caisses : 
	@Override
	public List<PayCashDesk> getAllCaisses(){
		return caisseRepo.findAll();
	}
	
	// lister les modes de reg d'une caisse donnée en param
	@Override
	public List<PayImpPyMorg> getModesReglements(Long id) {
		PayCashDesk caisse=this.caisseRepo.findById(id).get();
		return caisse.getPayimppymorg();
	}

	@Override
	public List<GenAccount> getAllClientAccounts(Long id) {
		return partyRepo.findById(id).get().getGenaccounts();
	}

	@Override
	public GenDebt EncaissementFacture(GenDebt genDebt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GenDebt> getAllFactures() {
		return this.genDebtRepo.findAll();
	}

	@Override
	public GenDebt SearchFacture(String ref) {
		GenDebt gen=new GenDebt();
		for(GenDebt g:genDebtRepo.findAll()){
			if(g.getDeb_refe().equals(ref)){
				gen=g;
			}
		}
		return gen;
	}

	@Override
	public List<GenDebt> getClientsFactures(Long id) {
		return this.genDebtRepo.findAll().stream().filter(d-> d.getParty().getPar_id()==id).collect(Collectors.toList());
	}
	
	@Override
	public GenDebt getDebtById(Long id){
		return this.genDebtRepo.findById(id).get();
	}
	
	@Override
	public List<Party> getAllParties(){
		return this.partyRepo.findAll();
	}

	@Override
	public Party getClientFact(GenDebt genDebt) {
		return genDebt.getParty();
	}

	@Override
	public List<GenOrg> getAllOrgs() {
		return this.genOrgRepo.findAll();
	}

}
