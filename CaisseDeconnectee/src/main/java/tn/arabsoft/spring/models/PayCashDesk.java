package tn.arabsoft.spring.models;

import java.util.List;
import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Caisse

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paycashdesk")
public class PayCashDesk {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cah_id;
	private String cah_code;
	private String cah_name;
	private String cah_maxtrans;
	private int cah_internal;
	private boolean cah_dayopen;
	
	@OneToMany(mappedBy="paycashdesk")
	private List<PayImpPyMorg> payimppymorg;
	
	
}
