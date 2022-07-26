package tn.arabsoft.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.arabsoft.spring.repositories.*;
import tn.arabsoft.spring.models.AgrServiceAgr;

@Service
public class AgrServiceAgrService implements IAgrServiceAgrService {

	@Autowired
	IArgServiceArgRepository contratRepo;
	
	@Override
	public AgrServiceAgr addContrat(AgrServiceAgr a) {
		return contratRepo.save(a);
	}

	@Override
	public AgrServiceAgr updateContrat(AgrServiceAgr a) {
		// TODO Auto-generated method stub
		return contratRepo.save(a);
	}

	@Override
	public void deleteContrat(int id) {
		contratRepo.deleteById(id);		
	}

	@Override
	public List<AgrServiceAgr> all() {
		return (List<AgrServiceAgr>) contratRepo.findAll();
	}

	@Override
	public AgrServiceAgr getById(int id) {
		return contratRepo.findById(id).orElse(null);
	}

}
