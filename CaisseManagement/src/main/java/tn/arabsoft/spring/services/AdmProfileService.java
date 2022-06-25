package tn.arabsoft.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.models.AdmUserProfile;
import tn.arabsoft.spring.repositories.IAdmProfileRepository;
import tn.arabsoft.spring.repositories.IAdmUserProfileRepository;

@Service
public class AdmProfileService implements IAdmProfileService {

	@Autowired
	IAdmProfileRepository admProfileRepository;
	
	@Autowired
	IAdmUserProfileRepository admUserProfileRepository;
	
	@Autowired
	MongoOperations mongoOperations;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;
	
	@Override
	public AdmProfile addProfile(AdmProfile profile, AdmUser user) {
		List<AdmUserProfile> ups=new ArrayList<AdmUserProfile>();
		ups=this.admUserProfileRepository.findAll();
		boolean test=false;
		AdmUserProfile up=new AdmUserProfile();
		for(AdmUserProfile upp : ups){
			for(AdmUser u : upp.getUser_aff()){
					test=(u.equals(user))?true:false;
					if(test==true) up=upp;
			}
		}
		if(test){
			// hetha ken l'user mawjoud deja f une affectation
			up.getUser_aff().add(user);
			up.getProfile_aff().add(profile);
			user.setUser_profile(up);
			profile.setUser_profile(up);
			// update up + update user + ajout profile
			mongoOperations.save(up);
			mongoOperations.save(user);
			admProfileRepository.insert(profile);
		}
		else{
		// hetha ken l'user mch mawjoud f hata aff => saret toul baad l'ajout mtaa l'user
		// user
			List<AdmUser> usersaff=new ArrayList<AdmUser>();
			usersaff.add(user);
			up.setUser_aff(usersaff);
		// profile
			List<AdmProfile> profileaff=new ArrayList<AdmProfile>();
			profileaff.add(profile);
			up.setProfile_aff(profileaff);
			user.setUser_profile(up);
			profile.setUser_profile(up);
			// ajout up + update user + ajout profile
			up.setUsp_id( sequenceGenerator.generateSequence(AdmUserProfile.SEQUENCE_NAME));
			admUserProfileRepository.insert(up);
			mongoOperations.save(user);
			admProfileRepository.insert(profile);
		}
		
		return profile;
		
	}

	@Override
	public void deleteProfile(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AdmProfile> listProfiles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdmProfile updateProfile(AdmProfile user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdmProfile getProfileById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
