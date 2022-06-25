package tn.arabsoft.spring.services;
import java.util.List;

import tn.arabsoft.spring.models.AdmUser;


public interface IAdmUserService {

	AdmUser addUser(AdmUser user);
	void deleteUser(int id);
	List<AdmUser> listUsers();
	AdmUser searchUser(String matricule);
	AdmUser updateUser(AdmUser user);
	AdmUser getUserById(int id);
	// show profiles of a user
	
	
}
