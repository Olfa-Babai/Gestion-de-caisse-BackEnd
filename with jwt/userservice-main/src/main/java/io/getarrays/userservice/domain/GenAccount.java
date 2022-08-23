package io.getarrays.userservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "genaccount")
public class GenAccount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long aco_id;
	private int aco_amount;
	
	@OneToOne(mappedBy="genaccount")
	private GenDebt gendebt;
	
	@JsonIgnore
	@ManyToOne
	private Party party;

}
