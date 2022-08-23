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

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "paycashdesk")
public class PayCashDesk {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cah_id;
	private String cah_code;
	private String cah_name;
	private String cah_maxtrans;
	private int cah_internal;
	private boolean cah_dayopen;
	
	@JsonIgnore
	@OneToMany(mappedBy="paycashdesk")
	private List<PayImpPyMorg> payimppymorg;
	
}
