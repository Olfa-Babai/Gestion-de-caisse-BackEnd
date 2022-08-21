package io.getarrays.userservice.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.DocumentException;

import io.getarrays.userservice.domain.*;

public interface UserProfileService {
	public AdmUserProfile addUserProfile(Long idp, Long idu);
	public AdmUserProfile searchAffUP(Role p, User u);
	int nbCaissiers();
	int nbsCH();
	int nbsAdmin();
	Map<String, List<Role>> organizing();
	Map<String, List<Role>> extract(String type);
	Map<String, List<Role>> searching(String word);
	void savetoPdf() throws FileNotFoundException, DocumentException;
	List<String> NotTheirRoles(Long id);
	Role findDominantRole(String username);
}
