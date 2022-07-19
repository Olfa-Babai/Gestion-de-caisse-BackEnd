package tn.arabsoft.spring.models;

import javax.persistence.Id;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
// contrat
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "agrserviceagr")
public class AgrServiceAgr {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sag_id;
	private String sag_refe;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="contrat")
	List<GenDebt> gendebts;
		
}
