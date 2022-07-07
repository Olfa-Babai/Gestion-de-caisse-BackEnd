package tn.arabsoft.spring.services;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.models.AdmUserProfile;

public interface IAdmUserProfileService {

	// ajouter une nouvelle affectation entre un user et un profil
	public AdmUserProfile addAffUP(int p, int u);
	// recherche aff d'un user à un profil
	public AdmUserProfile searchAffUP(AdmProfile p, AdmUser u);
	// stats 
	public int nbCaissiers();
	public int nbsCH();
	public int nbsAdmin();
	Map<AdmUser, List<AdmProfile>> organizing();
	void savetoPdf() throws FileNotFoundException, DocumentException;
	// afficher les caissiers ou CH ou admin
	Map<AdmUser, List<AdmProfile>> extract(String type);
	// recherche user or profile
	Map<AdmUser, List<AdmProfile>> searching(String word);
}
