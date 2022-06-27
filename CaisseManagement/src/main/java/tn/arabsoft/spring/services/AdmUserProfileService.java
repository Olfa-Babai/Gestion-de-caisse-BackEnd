package tn.arabsoft.spring.services;

import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.models.AdmUserProfile;

@Service
public class AdmUserProfileService implements IAdmUserProfileService {
	
	@Override
	public AdmUserProfile addAffUP(AdmProfile p, AdmUser u) {
		AdmUserProfile up= new AdmUserProfile();
		
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
