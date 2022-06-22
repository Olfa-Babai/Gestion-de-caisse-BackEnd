package tn.arabsoft.spring.models;


import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// agent
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("genagent")
public class GenAgent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int age_id;
	private String age_refe;
	private String age_login;
	private String age_pwd;
	
	@OneToOne
	private AdmUser admuser;
	
	@OneToMany(mappedBy="genagent")
	private List<PayCashDeskSession> paycashdesksessions;
	
	@OneToMany(mappedBy="genagent")
	private List<PayCashing> paycashings;
}
