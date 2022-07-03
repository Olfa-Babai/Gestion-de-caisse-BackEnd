package tn.arabsoft.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;
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
		profile.setPru_id(sequenceGenerator.generateSequence(AdmProfile.SEQUENCE_NAME));
		admProfileRepository.insert(profile);
		return profile;
	}

	@Override
	public void deleteProfile(int id) {
		admProfileRepository.deleteById(id);
	}

	@Override
	public List<AdmProfile> listProfiles() {
		return admProfileRepository.findAll();
	}

	@Override
	public AdmProfile updateProfile(AdmProfile profile) {
		return mongoOperations.save(profile);
	}

	@Override
	public AdmProfile getProfileById(int id) {
		return admProfileRepository.findById(id).orElse(null);
	}

}
