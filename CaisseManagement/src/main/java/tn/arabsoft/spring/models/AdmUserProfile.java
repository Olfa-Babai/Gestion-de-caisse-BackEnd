package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// affectation user - profile
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("admuserprofile")
public class AdmUserProfile {
	
	@Transient
    public static final String SEQUENCE_NAME = "userprofiles_sequence";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int usp_id;
	private String usp_granted;
	private Date usp_startdt;
	private Date usp_enddt;
	private int usp_credit;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private AdmUser user_aff;
	
	@ManyToOne
	private AdmProfile profile_aff;	
}
