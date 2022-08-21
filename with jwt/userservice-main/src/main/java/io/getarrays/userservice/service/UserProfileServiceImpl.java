package io.getarrays.userservice.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import io.getarrays.userservice.domain.*;
import io.getarrays.userservice.repo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserProfileServiceImpl implements UserProfileService {
	private final UserRepo userRepo;
	private final RoleRepo roleRepo;
	private final UserProfileRepo userPRepo;

	@Override
	public AdmUserProfile addUserProfile(Long ip, Long iu) {
		AdmUserProfile up = new AdmUserProfile();
		User u = userRepo.findById(iu).orElse(null);
		Role p = roleRepo.findById(ip).orElse(null);
		up.setProfile_aff(p);
		up.setUser_aff(u);
		return userPRepo.save(up);
	}

	@Override
	public AdmUserProfile searchAffUP(Role p, User u) {
		AdmUserProfile aup = new AdmUserProfile();
		for (AdmUserProfile up : this.userPRepo.findAll()) {
			if (up.getUser_aff().equals(u) && up.getProfile_aff().equals(p)) {
				aup = up;
			}
		}
		return aup;
	}

	@Override
	public int nbCaissiers() {
		int c = 0;
		for (AdmUserProfile up : this.userPRepo.findAll())
			if (up.getProfile_aff().getName().equals(Profile.ROLE_CAISSIER))
				c++;
		return c;
	}

	@Override
	public int nbsCH() {
		int c = 0;
		for (AdmUserProfile up : this.userPRepo.findAll())
			if (up.getProfile_aff().getName().equals(Profile.ROLE_CHEFHIERARCHIQUE))
				c++;
		return c;
	}

	@Override
	public int nbsAdmin() {
		int c = 0;
		for (AdmUserProfile up : this.userPRepo.findAll())
			if (up.getProfile_aff().getName().equals(Profile.ROLE_ADMINISTRATEUR))
				c++;
		return c;
	}

	public List<Role> getRolesOfUser(Long id) {
		User user=userRepo.findById(id).get();
		List<Role> roles=new ArrayList<>();
		for(AdmUserProfile usp: userPRepo.findAll()){
			if(usp.getUser_aff().getUsername().equals(user.getUsername())){
				roles.add(usp.getProfile_aff());
			}
		}
		return roles;
	}
	
	@Override
	public Map<String, List<Role>> organizing() {
		List<AdmUserProfile> ups = (List<AdmUserProfile>) this.userPRepo.findAll();
		Map<String, List<Role>> map = new HashMap<String, List<Role>>();
		for(User u : this.userRepo.findAll()){
			map.put(u.getUsername(),this.getRolesOfUser(u.getUse_id()));
		}
		return map;
	}

	@Override
	public Map<String, List<Role>> extract(String type) {
		Map<String, List<Role>> map = new HashMap<String, List<Role>>();
		Map<String, List<Role>> m = this.organizing();
		for (Map.Entry mapentry : m.entrySet()) {
			List<Role> profiles = (List<Role>) mapentry.getValue();
			for (Role p : profiles) {
				if (p.getName().toString().equals(type)) {
					map.put((String) mapentry.getKey(), (List<Role>) mapentry.getValue());
				}
			}
		}
		return map;
	}

	@Override
	public void savetoPdf() throws FileNotFoundException, DocumentException {

		// les données :
		Map<String, List<Role>> list = this.organizing();

		String file_name = System.getProperty("user.home") + "\\Desktop\\usersProfiles.pdf";
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file_name));

		// titre :
		document.open();
		Paragraph title = new Paragraph(" Liste des utilisateurs et leurs profiles ");
		document.add(title);
		document.add(new Paragraph(" "));

		Paragraph caissiers = new Paragraph(" Nombre de caissiers : " + this.nbCaissiers());
		document.add(caissiers);
		document.add(new Paragraph(" "));

		Paragraph chefhs = new Paragraph(" Nombre de Chef Hiérarchiques : " + this.nbsCH());
		document.add(chefhs);
		document.add(new Paragraph(" "));

		Paragraph admins = new Paragraph(" Nombre d'administrateurs : " + this.nbsAdmin());
		document.add(admins);
		document.add(new Paragraph(" "));

		// tableau :
		PdfPTable donnee = new PdfPTable(2);
		donnee.setWidthPercentage(100);

		PdfPCell cell;
		cell = new PdfPCell(new Phrase("Utilisateurs"));
		donnee.addCell(cell);
		cell = new PdfPCell(new Phrase("Profiles"));
		donnee.addCell(cell);

		Iterator<Entry<String, List<Role>>> i = list.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry mapentry = (Map.Entry) i.next();
			PdfPCell b1 = new PdfPCell(new Phrase("@"+mapentry.getKey().toString() + ""));
			donnee.addCell(b1);
			PdfPCell b2 = new PdfPCell(new Phrase(mapentry.getValue().toString() + ""));
			donnee.addCell(b2);
		}

		document.add(donnee);
		document.close();
	}

	public boolean containsword(List<Role> ps, String word) {
		boolean test = false;
		for (Role p : ps) {
			if (p.getPru_label().contains(word) || p.getName().toString().contains(word))
				test = true;
		}
		return test;
	}

	
	@Override
	public Map<String, List<Role>> searching(String word) {
		Map<String, List<Role>> map = new HashMap<String, List<Role>>();
		Map<String, List<Role>> m = this.organizing();
		for (Map.Entry mapentry : m.entrySet()) {
			String u = (String) mapentry.getKey();
			List<Role> ps = (List<Role>) mapentry.getValue();
			if (u.contains(word)) {
				map.put(u, ps);
			}
		}
		return map;
	}

	@Override
	public List<String> NotTheirRoles(Long id){
		boolean testA=false;
		boolean testC=false;
		boolean testCH=false;
		List<String> notRoles=new ArrayList<String>();
		for(Role r : this.getRolesOfUser(id)){
			switch(r.getName().toString()){
			case "ROLE_ADMINSTRATEUR" : testA=true;
			case "ROLE_CHEFHIERARCHIQUE" : testCH=true;
			case "ROLE_CAISSIER" : testC=true;
			}
		}
		if(testA==false){
			notRoles.add("ROLE_ADMINISTRATEUR");
		}
		if(testCH==false){
			notRoles.add("ROLE_CHEFHIERARCHIQUE");
		}
		if(testC==false){
			notRoles.add("ROLE_CAISSIER");
		}
		return notRoles;
	}
	
	@Override
	public Role findDominantRole(String username) {
		User u=this.userRepo.findByUsername(username);
		boolean testAdmin=false;
		boolean testCH=false;
		Role roleSelected=new Role();
		List<Role> roles=this.getRolesOfUser(u.getUse_id());
		for(Role r : roles){
			if(r.getName().equals(Profile.ROLE_ADMINISTRATEUR))
			{
				testAdmin=true;
				roleSelected=r;
			}
			else if(r.getName().equals(Profile.ROLE_CHEFHIERARCHIQUE) && testAdmin==false)
			{
				testCH=true;
				roleSelected=r;
			}
			else if (r.getName().equals(Profile.ROLE_CAISSIER) && testAdmin==false && testCH==false)
			{
				roleSelected=r;
			}
		}
		log.info("Adding role {} ", roleSelected.getName());
		return roleSelected;
	}

}
