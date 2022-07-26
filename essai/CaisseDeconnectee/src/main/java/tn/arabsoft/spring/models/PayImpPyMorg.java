package tn.arabsoft.spring.models;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//mode de reglement
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paycashdesk")
public class PayImpPyMorg {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pyim_id;
	private int pyo_id;
	private String pym_code;
	private String pym_name;
	
	@ManyToOne
	private PayCashDesk paycashdesk;
}
