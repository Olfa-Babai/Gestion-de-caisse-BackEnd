package tn.arabsoft.spring.services;

import java.util.List;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;

public interface IAdmProfileService {

	AdmProfile addProfile(AdmProfile profile, AdmUser user);
	void deleteProfile(int id);
	List<AdmProfile> listProfiles(); // all profiles in the db
	AdmProfile updateProfile(AdmProfile user);
	AdmProfile getProfileById(int id);
	
}
