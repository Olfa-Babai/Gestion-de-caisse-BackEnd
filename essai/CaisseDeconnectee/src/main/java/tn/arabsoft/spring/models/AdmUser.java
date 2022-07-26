package tn.arabsoft.spring.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// user
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admuser")
public class AdmUser {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int use_id;
	private String use_matricule; // cin ou passeport
	private String use_login;
	private String use_psw;
	private String use_lname;
	private String use_fname;
	private int use_nbessai;
	private String use_cptestatus;
	private LocalDateTime use_crtdt;
	private LocalDateTime use_lastcnx;
	private String use_nmadm;
	private String use_type;
	private String use_status;
	
	@Override
	public String toString() {
		return "  Matricule :" + use_matricule +" | Nom et prenom : "+  use_lname+" " + use_fname + " ";
	}
	
	@OneToOne(mappedBy="admuser",cascade = CascadeType.ALL)
	private GenAgent genagent;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user_aff")
	List<AdmUserProfile> user_profile_aff=new ArrayList<AdmUserProfile>();
	
}
