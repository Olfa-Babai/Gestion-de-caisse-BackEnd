package tn.arabsoft.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
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
	public PayCashDesk addCaisse(PayCashDesk c, int[] id) {
		List<PayImpPyMorg> lp= new ArrayList<PayImpPyMorg>();
		for(int i : id){
			lp.add(pRepo.findById(i).orElse(null));
		}		
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
