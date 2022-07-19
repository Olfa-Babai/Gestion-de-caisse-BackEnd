package tn.arabsoft.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
		
	@Override
	public AdmProfile addProfile(AdmProfile profile, AdmUser user) {
		admProfileRepository.save(profile);
		return profile;
	}

	@Override
	public void deleteProfile(int id) {
		admProfileRepository.deleteById(id);
	}

	@Override
	public List<AdmProfile> listProfiles() {
		return (List<AdmProfile>) admProfileRepository.findAll();
	}

	@Override
	public AdmProfile updateProfile(AdmProfile profile,int id) {
		return admProfileRepository.findById(id)
                .map(p -> {
                    p.setPru_label(profile.getPru_label());
                    p.setPru_role(profile.getPru_role());
                    p.setPru_natusp(profile.getPru_natusp());
                    return admProfileRepository.save(p);
                }).orElse(null);
	}

	@Override
	public AdmProfile getProfileById(int id) {
		return admProfileRepository.findById(id).orElse(null);
	}

}
