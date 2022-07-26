package io.getarrays.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.*;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "admuser")
public class User {
    @Id @GeneratedValue(strategy = AUTO)
    private Long use_id;
    private String use_matricule;
    private String fname;
    private String lname;
    private String username;
    private String password;
	private int use_nbessai;
	private String use_cptestatus;
	private LocalDateTime use_crtdt;
	private LocalDateTime use_lastcnx;
	private String use_nmadm;
	private String use_type;
	private String use_status;
	/*
    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();
    */
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user_aff")
    Collection<AdmUserProfile> user_profile_aff=new ArrayList<>();
    
    @Override
	public String toString() {
		return "  Matricule :" + use_matricule +" | Nom et prenom : "+  lname+" " + fname + " ";
	}    
}
