package io.getarrays.userservice.domain;

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

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "payimppymorg")
public class PayImpPyMorg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pyim_id;
	private int pyo_id;
	private String pym_code;
	private String pym_name;
	
	@ManyToOne
	private PayCashDesk paycashdesk;
}
