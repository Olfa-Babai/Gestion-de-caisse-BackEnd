package io.getarrays.userservice.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "genbank")
public class GenBank {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ban_id;
	private String ban_code;
	private String ban_name;
	private String ban_bic;
	
	@OneToMany(mappedBy="genbank")
	List<PayCashing> paycashings;

}
