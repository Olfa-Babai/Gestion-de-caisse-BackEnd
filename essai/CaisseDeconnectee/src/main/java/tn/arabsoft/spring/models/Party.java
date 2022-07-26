package tn.arabsoft.spring.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//client
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "party")
public class Party {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int par_id;
	private String par_refe;
	private String par_refe_rxt;
	private String par_name;
	private String address;
	
	@OneToMany(mappedBy="party")
	private List<GenAccount> genaccounts;
	
	@OneToMany(mappedBy="party")
	private List<GenDebt> gendebt;
	
	
}
