package tn.arabsoft.spring.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// affectation user - profile
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admuserprofile")
public class AdmUserProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int usp_id;
	private String usp_granted;
	private Date usp_startdt;
	private Date usp_enddt;
	private int usp_credit;
	private String login;
	private String password;
	
	@ManyToOne
	private AdmUser user_aff;
	
	@ManyToOne
	private AdmProfile profile_aff;	
	
	@OneToMany(mappedBy="userprofile")
	private List<PayCashDeskSession> paycashdesksessions=new ArrayList<PayCashDeskSession>(); 
}
