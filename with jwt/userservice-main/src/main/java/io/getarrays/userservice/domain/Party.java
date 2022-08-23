package io.getarrays.userservice.domain;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "party")
public class Party {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long par_id;
	private String par_refe;
	private String par_refe_rxt;
	private String par_name;
	private String address;
	
	
	@OneToMany(mappedBy="party")
	private List<GenAccount> genaccounts;
	
	@JsonIgnore
	@OneToMany(mappedBy="party")
	private List<GenDebt> gendebt;
}
