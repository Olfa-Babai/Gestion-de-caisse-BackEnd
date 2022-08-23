package io.getarrays.userservice.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String age_login;
	private String age_pwd;
	
	@JsonIgnore
	@OneToOne
	private User admuser;
	
	/*
	@OneToMany(mappedBy="genagent",cascade = CascadeType.ALL)
	List<PayCashing> paycashing;
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="genagent")
	List<PayCashDeskSession> paycashdesksession;
	 */
	
}
