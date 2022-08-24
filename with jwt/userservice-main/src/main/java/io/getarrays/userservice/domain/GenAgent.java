package io.getarrays.userservice.domain;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "genagent")
public class GenAgent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long age_id;
	private String age_refe;
	private String age_name;
	@Column(name="age_login")
	private String agelogin;
	private String age_pwd;
	
	@JsonIgnore
	@OneToOne
	private User admuser;
	
	/*
	@OneToMany(mappedBy="genagent",cascade = CascadeType.ALL)
	List<PayCashing> paycashing;
	*/
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="genagent")
	List<PayCashDeskSession> paycashdesksession;
	 
	
}
