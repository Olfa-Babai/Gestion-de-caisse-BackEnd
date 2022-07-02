package tn.arabsoft.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.GenBank;
import tn.arabsoft.spring.repositories.IGenBankRepository;

@Service 
public class GenBankService implements IGenBankService {

	@Autowired
	IGenBankRepository genBankRepo;
	
	
	@Override
	public GenBank ajoutBank(GenBank b) {
		return genBankRepo.insert(b);
	}

}
