package tn.arabsoft.spring.models;


import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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

	@Transient
    public static final String SEQUENCE_NAME = "agents_sequence";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int age_id;
	private String age_refe;
	private String age_name;
	private String age_login;
	private String age_pwd;
	
	private AdmUser admuser;
	
	@DBRef
	private List<PayCashDeskSession> paycashdesksessions;
	
	@DBRef
	private List<PayCashing> paycashing;
}
