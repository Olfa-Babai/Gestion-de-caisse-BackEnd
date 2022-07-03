package tn.arabsoft.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.PayImpPyMorg;
import tn.arabsoft.spring.repositories.IPayImpPyMorgRepository;

@Service
public class PayImpPyMorgService implements IPayImpPyMorgService {

	@Autowired
	IPayImpPyMorgRepository payRepo;
	
	@Override
	public PayImpPyMorg add(PayImpPyMorg p) {
		return payRepo.insert(p);
	}

}
