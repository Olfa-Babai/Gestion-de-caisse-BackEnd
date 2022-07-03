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
import org.springframework.data.mongodb.core.MongoOperations;
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

	@Autowired
	SequenceGeneratorService sequenceGenerator;

	@Autowired
	MongoOperations mongoOperations;

	@Override
	public AdmUserProfile addAffUP(int ip, int iu) {
		AdmUserProfile up = new AdmUserProfile();
		AdmUser u = admu.findById(iu).orElse(null);
		AdmProfile p = admp.findById(ip).orElse(null);
		up.setProfile_aff(p);
		up.setUser_aff(u);
		up.setUsp_id(sequenceGenerator.generateSequence(AdmUserProfile.SEQUENCE_NAME));
		admUserProfileRepository.insert(up);
		return up;
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
		List<AdmUserProfile> ups = this.admUserProfileRepository.findAll();
		Map<AdmUser, List<AdmProfile>> map = new HashMap<AdmUser, List<AdmProfile>>();
		List<AdmProfile> ps = new ArrayList<AdmProfile>();
		int i=0;
		for ( i = 0; i < ups.size()-1; i++) {
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

}
