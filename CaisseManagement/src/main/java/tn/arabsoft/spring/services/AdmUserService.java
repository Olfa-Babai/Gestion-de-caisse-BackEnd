package tn.arabsoft.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.repositories.IAdmUserRepository;

@Service
public class AdmUserService implements IAdmUserService {

	@Autowired
	IAdmUserRepository userRepository;

	@Override
	public AdmUser addUser(AdmUser user) {
		return userRepository.insert(user);
	}

	AdmUser update(){
		//MongoOperations
		return null;
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

}
