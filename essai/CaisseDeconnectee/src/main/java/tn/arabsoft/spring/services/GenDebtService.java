package tn.arabsoft.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.repositories.IGenDebtRepository;

@Service
public class GenDebtService implements IGenDebtService {

	@Autowired
	IGenDebtRepository genrepo;
	
	
	void test(){
	//	genrepo.
	}
}
