package tn.arabsoft.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.PayCashDesk;
import tn.arabsoft.spring.models.PayImpPyMorg;
import tn.arabsoft.spring.repositories.IPayCashDeskRepository;
import tn.arabsoft.spring.repositories.IPayImpPyMorgRepository;

@Service
public class PayCashDeskService implements IPayCashDeskService {

	@Autowired
	IPayImpPyMorgRepository pRepo;
	
	@Autowired
	MongoOperations mongo;
	
	@Autowired
	IPayCashDeskRepository caisseRepo;
	@Override
	public PayCashDesk addCaisse(PayCashDesk c, List<Integer> id) {
		List<PayImpPyMorg> p=(List<PayImpPyMorg>)pRepo.findAllById(id);
		List<PayImpPyMorg> lp= new ArrayList<PayImpPyMorg>();
		lp.addAll(p);
		c.setPayimppymorg(lp);
		return caisseRepo.insert(c);
	}

	@Override
	public PayCashDesk getCaisse(int id) {
		return caisseRepo.findById(id).orElse(null);
	}

	@Override
	public List<PayCashDesk> getAllCaisse() {
		return caisseRepo.findAll();
	}

	@Override
	public void deleteCaisse(int id) {
		caisseRepo.deleteById(id);
		
	}

	@Override
	public PayCashDesk updateCaisse(PayCashDesk c) {
		return mongo.save(c);
	}

}
