package tn.arabsoft.spring.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

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

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int usp_id;
	private String usp_granted;
	private Date usp_startdt;
	private Date usp_enddt;
	private int usp_credit;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user_profile")
	private List<AdmUser> user_aff;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user_profile")
	private List<AdmProfile> profile_aff;	
}
