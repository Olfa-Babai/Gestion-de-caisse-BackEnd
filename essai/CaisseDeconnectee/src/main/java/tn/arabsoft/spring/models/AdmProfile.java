package tn.arabsoft.spring.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// profile
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admprofile")
public class AdmProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pru_id;
	private String pru_label;	private String pru_status;
	@Enumerated(EnumType.STRING)
	private Role pru_role;
	private LocalDateTime pru_updtprudt;
	private String pru_natusp;
	@Override
	public String toString() {
		return " id : " + pru_id + ", role : " + pru_role + " \n";
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="profile_aff")
	List<AdmUserProfile> user_profile_aff= new ArrayList<AdmUserProfile>();
	
}
