package tn.arabsoft.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.GenOrg;
import tn.arabsoft.spring.repositories.IGenOrgRepository;

@Service
public class GenOrgService implements IGenOrgService {

	@Autowired
	IGenOrgRepository orgRepo;
	
	@Override
	public GenOrg addOrg(GenOrg o) {
		return orgRepo.save(o);
	}

}
