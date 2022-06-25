package tn.arabsoft.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.repositories.IAdmUserRepository;

@Service
public class AdmUserService implements IAdmUserService {

	@Autowired
	IAdmUserRepository userRepository;
	
	@Autowired
	MongoOperations mongoOperations;

	@Override
	public AdmUser addUser(AdmUser user) {
		return userRepository.insert(user);
	}

	@Override
	public AdmUser updateUser(AdmUser user){
		return mongoOperations.save(user);
	}
	
	@Override
	public void deleteUser(int id) {
		 userRepository.deleteById(id);
	}

	@Override
	public List<AdmUser> listUsers() {
		return userRepository.findAll();
	}

	@Override
	public AdmUser searchUser(String matricule) {
		List<AdmUser> all=userRepository.findAll();
		AdmUser finalu=new AdmUser();
		for(AdmUser u : all){
			if(u.getUse_matricule().equals(matricule)){
				finalu=u;
			}
		}
		return finalu;
	}

	@Override
	public AdmUser getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

}
