package tn.arabsoft.spring.services;

import java.util.List;

import tn.arabsoft.spring.models.AgrServiceAgr;

public interface IAgrServiceAgrService {

	public AgrServiceAgr addContrat(AgrServiceAgr a);
	public AgrServiceAgr updateContrat(AgrServiceAgr a);
	public void deleteContrat(int id);
	public List<AgrServiceAgr> all();
	public AgrServiceAgr getById(int id);
} 
