package tn.arabsoft.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.models.AdmUserProfile;
import tn.arabsoft.spring.repositories.*;

@Service
public class AdmUserProfileService implements IAdmUserProfileService {
	
	@Autowired
	IAdmUserProfileRepository admUserProfileRepository ;
	
	@Autowired
	IAdmUserRepository admu;
	
	@Autowired
	IAdmProfileRepository admp;
	
	@Autowired
	SequenceGeneratorService sequenceGenerator;

	@Autowired
	MongoOperations mongoOperations;
	
	@Override
	public AdmUserProfile addAffUP(int ip, int iu) {
		AdmUserProfile up= new AdmUserProfile();
		AdmUser u= admu.findById(iu).orElse(null);
		AdmProfile p=admp.findById(ip).orElse(null);
		/*
		if(u.getUser_profiles()==null) u.setUser_profiles(new ArrayList<AdmUserProfile>());
		if(p.getUser_profiles()==null) p.setUser_profiles(new ArrayList<AdmUserProfile>());
		u.getUser_profiles().add(up);
		p.getUser_profiles().add(up); */
		up.setProfile_aff(p);
		up.setUser_aff(u);
		up.setUsp_id(sequenceGenerator.generateSequence(AdmUserProfile.SEQUENCE_NAME));
		admUserProfileRepository.insert(up);
		return up;
	}

	@Override
	public AdmUserProfile addAffUToP(AdmProfile p, AdmUser u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdmUserProfile addAffPToU(AdmProfile p, AdmUser u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdmUserProfile searchAffUP(AdmProfile p, AdmUser u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nbCaissiers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nbsCH() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int nbsAdmin() {
		// TODO Auto-generated method stub
		return 0;
	}

}
