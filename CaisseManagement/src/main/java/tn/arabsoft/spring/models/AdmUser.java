package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// user
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("admuser")
public class AdmUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int use_id;
	private String use_matricule;
	private String use_login;
	private String use_psw;
	private String use_lname;
	private String use_fname;
	private int use_nbessai;
	private String use_cptestatus;
	private Date use_crtdt;
	private Date use_lastcnx;
	private String use_nmadm;
	private String use_type;
	private String use_status;
	
	@ManyToOne
	private AdmUserProfile user_profile;
	
	@OneToOne(mappedBy="admuser")
	private GenAgent genagent;
	
}
