package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paycashing")
public class PayCashing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int csh_id;
	private int csh_rejet_id;
	private Date csh_date;
	private int sli_id;
	private int csh_amount;
	private int cur_id;
	private String csh_bankdocument;
	private String csh_bank;
	private int vow_rejmotif;
	
	@ManyToOne
	private GenBank genbank;
	
	@ManyToOne
	private GenAgent genagent;
		
}
