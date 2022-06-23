package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// profile
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="admprofile")
public class AdmProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pru_id;
	private String pru_label;
	private String pru_status;
	@Enumerated(EnumType.STRING)
	private Role pru_role;
	private Date pru_updtprudt;
	private String pru_natusp;
	
	@ManyToOne
	private AdmUserProfile user_profile;
	
}
