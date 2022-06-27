package tn.arabsoft.spring.services;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.models.AdmUserProfile;

public interface IAdmUserProfileService {

	// ajouter une nouvelle affectation entre un user et un profil
	public AdmUserProfile addAffUP(int p, int u);
	// affecter un profil à un user
	public AdmUserProfile addAffUToP(AdmProfile p, AdmUser u);
	// affecter un user à un profil
	public AdmUserProfile addAffPToU(AdmProfile p, AdmUser u);
	// recherche aff d'un user à un profil
	public AdmUserProfile searchAffUP(AdmProfile p, AdmUser u);
	// stats 
	public int nbCaissiers();
	public int nbsCH();
	public int nbsAdmin();
}
