package io.getarrays.userservice.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "paycashing")
public class PayCashing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long csh_id;
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
