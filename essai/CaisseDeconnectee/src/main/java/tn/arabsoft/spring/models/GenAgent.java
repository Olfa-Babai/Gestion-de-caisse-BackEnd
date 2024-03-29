package tn.arabsoft.spring.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
// agent
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genagent")
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
	
	@JsonIgnore
	@OneToOne
	private AdmUser admuser;
	
	@OneToMany(mappedBy="genagent",cascade = CascadeType.ALL)
	List<PayCashing> paycashing;
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="genagent")
	List<PayCashDeskSession> paycashdesksession;
}
