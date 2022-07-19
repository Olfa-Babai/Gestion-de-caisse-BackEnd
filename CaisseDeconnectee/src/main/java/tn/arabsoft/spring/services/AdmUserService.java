package tn.arabsoft.spring.services;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.models.GenAgent;
import tn.arabsoft.spring.repositories.IAdmUserRepository;
import tn.arabsoft.spring.repositories.IGenAgentRepository;

@Service
public class AdmUserService implements IAdmUserService {

	@Autowired
	IAdmUserRepository userRepository;
	
	@Autowired
	IGenAgentRepository agentRepo;
	
	@Override
	public AdmUser addUser(AdmUser user) {
		// creation d'un agent
		GenAgent agent=new GenAgent();
		agent.setAge_refe(user.getUse_matricule());
		agent.setAge_name(user.getUse_fname()+" "+user.getUse_lname());
		agent.setAge_login(user.getUse_login());
		agent.setAge_pwd(user.getUse_psw());
		// ajout user & agent
		user.setGenagent(agent);
		agent.setAdmuser(user);
		// saving
		userRepository.save(user);
		return user;
	}

	@Override
	public AdmUser updateUser(AdmUser user){
		return this.userRepository.save(user);
	}
	
	@Override
	public void deleteUser(int id) {
		 userRepository.deleteById(id);
	}

	@Override
	public List<AdmUser> listUsers() {
		return (List<AdmUser>) userRepository.findAll();
	}

	@Override
	public AdmUser searchUser(String matricule) {
		List<AdmUser> all=(List<AdmUser>) userRepository.findAll();
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

	@Override
	public List<AdmUser> listUsersSortedAF() {
		List<AdmUser> list= (List<AdmUser>) userRepository.findAll();
		return list.stream().sorted(Comparator.comparing(AdmUser::getUse_fname))
				.collect(Collectors.toList());
	}
	
	@Override
	public List<AdmUser> listUsersSortedDF() {
		List<AdmUser> list= (List<AdmUser>) userRepository.findAll();
		return list.stream().sorted(Comparator.comparing(AdmUser::getUse_fname).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<AdmUser> listUsersSortedD() {
		List<AdmUser> list= (List<AdmUser>) userRepository.findAll();
		return list.stream().sorted(Comparator.comparing(AdmUser::getUse_lname).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public List<AdmUser> listUsersSortedA() {
		List<AdmUser> list= (List<AdmUser>) userRepository.findAll();
		return list.stream().sorted(Comparator.comparing(AdmUser::getUse_lname))
				.collect(Collectors.toList());
	}

}
