package tn.arabsoft.spring.services;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.arabsoft.spring.models.AdmProfile;
import tn.arabsoft.spring.models.AdmUser;
import tn.arabsoft.spring.models.AdmUserProfile;
import tn.arabsoft.spring.models.Role;
import tn.arabsoft.spring.repositories.*;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class AdmUserProfileService implements IAdmUserProfileService {

	@Autowired
	IAdmUserProfileRepository admUserProfileRepository;

	@Autowired
	IAdmUserRepository admu;

	@Autowired
	IAdmProfileRepository admp;

	@Override
	public AdmUserProfile addAffUP(int ip, int iu) {
		AdmUserProfile up = new AdmUserProfile();
		AdmUser u = admu.findById(iu).orElse(null);
		AdmProfile p = admp.findById(ip).orElse(null);
		up.setLogin(u.getUse_login()+p.getPru_role().toString());
		up.setPassword(u.getUse_psw());
		up.setProfile_aff(p);
		up.setUser_aff(u);
		return admUserProfileRepository.save(up);
	}

	@Override
	public AdmUserProfile searchAffUP(AdmProfile p, AdmUser u) {
		AdmUserProfile aup=new AdmUserProfile();
		for(AdmUserProfile up : this.admUserProfileRepository.findAll()){
			if(up.getUser_aff().equals(u) && up.getProfile_aff().equals(p)){
				aup=up;
			}
		}
		return aup;
	}

	@Override
	public int nbCaissiers() {
		int c=0;
		for(AdmUserProfile up : this.admUserProfileRepository.findAll())
			if(up.getProfile_aff().getPru_role().equals(Role.Caissier))
				c++;
		return c;
	}

	@Override
	public int nbsCH() {
		int c=0;
		for(AdmUserProfile up : this.admUserProfileRepository.findAll())
			if(up.getProfile_aff().getPru_role().equals(Role.ChefHierarchique))
				c++;
		return c;
	}

	@Override
	public int nbsAdmin() {
		int c=0;
		for(AdmUserProfile up : this.admUserProfileRepository.findAll())
			if(up.getProfile_aff().getPru_role().equals(Role.Administrateur))
				c++;
		return c;
	}

	@Override
	public Map<AdmUser, List<AdmProfile>> organizing() {
		List<AdmUserProfile> ups = (List<AdmUserProfile>) this.admUserProfileRepository.findAll();
		Map<AdmUser, List<AdmProfile>> map = new HashMap<AdmUser, List<AdmProfile>>();
		List<AdmProfile> ps = new ArrayList<AdmProfile>();
		int i=0;
		if(ups.size()>1)
		{for ( i = 0; i < ups.size()-1; i++) {
			AdmUser u = ups.get(i).getUser_aff();
			ps.add(ups.get(i).getProfile_aff());
			if (!(ups.get(i + 1).getUser_aff().equals(u))) {
				map.put(u, ps);
				ps=new ArrayList<AdmProfile>();
				if(i==ups.size()-2){
					ps.add(ups.get(i+1).getProfile_aff());
					map.put(ups.get(i+1).getUser_aff(), ps);
					ps=new ArrayList<AdmProfile>();
				}
			}
		}}
		else if(ups.size()==1){
			ps.add(ups.get(0).getProfile_aff());
			map.put(ups.get(0).getUser_aff(), ps);
		}
		else return null;
		
		return map;
	}
	
	@Override
	public Map<AdmUser, List<AdmProfile>> extract(String type){
		Map<AdmUser, List<AdmProfile>> map = new HashMap<AdmUser, List<AdmProfile>>();
		Map<AdmUser, List<AdmProfile>> m=this.organizing();
		for (Map.Entry mapentry : m.entrySet()) {
			List<AdmProfile> profiles=(List<AdmProfile>) mapentry.getValue();
			for(AdmProfile p : profiles){
				if (p.getPru_role().toString().equals(type)){
					map.put((AdmUser)mapentry.getKey(),(List<AdmProfile>)mapentry.getValue());
				}
			}
		}
		return map;
	}

	@Override
	public void savetoPdf() throws FileNotFoundException, DocumentException {

		// les données :
		Map<AdmUser, List<AdmProfile>> list = this.organizing();

		String file_name = System.getProperty("user.home") + "\\Desktop\\usersProfiles.pdf";
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(file_name));

		// titre :
		document.open();
		Paragraph title = new Paragraph(" Liste des utilisateurs et leurs profiles ");
		document.add(title);
		document.add(new Paragraph(" "));

		Paragraph caissiers = new Paragraph(" Nombre de caissiers : "+this.nbCaissiers());
		document.add(caissiers);
		document.add(new Paragraph(" "));
		
		Paragraph chefhs = new Paragraph(" Nombre de Chef Hiérarchiques : "+this.nbsCH());
		document.add(chefhs);
		document.add(new Paragraph(" "));
		
		Paragraph admins = new Paragraph(" Nombre d'administrateurs : "+this.nbsAdmin());
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

		Iterator<Entry<AdmUser, List<AdmProfile>>> i = list.entrySet().iterator();
		while (i.hasNext()) {
			Map.Entry mapentry = (Map.Entry) i.next();
			PdfPCell b1 = new PdfPCell(new Phrase(mapentry.getKey().toString() + ""));
			donnee.addCell(b1);
			PdfPCell b2 = new PdfPCell(new Phrase(mapentry.getValue().toString() + ""));
			donnee.addCell(b2);
		}

		document.add(donnee);
		document.close();
	}

	public boolean containsword(List<AdmProfile> ps, String word){
		boolean test=false;
		for(AdmProfile p:ps){
			if(p.getPru_label().contains(word)||p.getPru_status().contains(word))
				test=true;
		}
		return test;
	}
	
	@Override
	public Map<AdmUser, List<AdmProfile>> searching(String word) {
		Map<AdmUser, List<AdmProfile>> map = new HashMap<AdmUser, List<AdmProfile>>();
		Map<AdmUser, List<AdmProfile>> m=this.organizing();
		for (Map.Entry mapentry : m.entrySet()) {
			AdmUser u=(AdmUser)mapentry.getKey();
			List<AdmProfile> ps=(List<AdmProfile>)mapentry.getValue();
			if(u.getUse_fname().contains(word)||u.getUse_lname().contains(word)||containsword(ps,word)){
				map.put(u, ps);
			}
		}
		return map;
	}
	
	@Override
	public List<AdmProfile> getprofilesuser(int id){
		AdmUser user=this.admu.findById(id).get();
		List<AdmProfile> p=new ArrayList<AdmProfile>();
		for(AdmUserProfile usp : this.admUserProfileRepository.findAll()){
			if(usp.getUser_aff().equals(user)){
				p.add(usp.getProfile_aff());
			}
		}
		return p;
	}

	@Override
	public AdmUserProfile loginUP(String login, String pwd, String role) {
		AdmUserProfile upp =new AdmUserProfile();
		for(AdmUserProfile usp : this.admUserProfileRepository.findAll()){
			if(usp.getUser_aff().getUse_login().equals(login) && usp.getUser_aff().getUse_psw().equals(pwd) && usp.getProfile_aff().getPru_role().toString().equals(role)){
				upp=usp;
			}
		}
		return upp;
	}

	@Override
	public AdmUserProfile findByLogin(String login) {
		return this.findByLogin(login);
	}

}
