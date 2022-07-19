package tn.arabsoft.spring.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
// compte client :
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genaccount")
public class GenAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aco_id;
	private int aco_amount;
	
	@OneToOne(mappedBy="genaccount")
	private GenDebt gendebt;
	
	@ManyToOne
	private Party party;
	
}
