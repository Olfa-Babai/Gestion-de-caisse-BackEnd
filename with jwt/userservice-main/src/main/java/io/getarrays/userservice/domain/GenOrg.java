package io.getarrays.userservice.domain;

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

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "genorg")
public class GenOrg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long org_id;
	private String org_name;
	
	@JsonIgnore
	@OneToMany(mappedBy="genorg")
	List<GenDebt> gendebts;
}
