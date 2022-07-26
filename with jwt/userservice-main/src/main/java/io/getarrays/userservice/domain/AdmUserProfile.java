package io.getarrays.userservice.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admuserprofile")
public class AdmUserProfile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long usp_id;
	private String usp_granted;
	private Date usp_startdt;
	private Date usp_enddt;
	private int usp_credit;
	private String login;
	
	@ManyToOne
	private User user_aff;
	
	@ManyToOne
	private Role profile_aff;	
	
	/*
	 * @OneToMany(mappedBy="userprofile")
	private List<PayCashDeskSession> paycashdesksessions=new ArrayList<PayCashDeskSession>(); 
	 */
	
}
