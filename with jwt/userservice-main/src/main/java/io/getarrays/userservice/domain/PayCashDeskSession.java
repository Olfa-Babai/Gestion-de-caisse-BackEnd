package io.getarrays.userservice.domain;

import java.time.LocalDateTime;

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

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "paycashdesksession")
public class PayCashDeskSession {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long css_id;
	
	private LocalDateTime css_enddt;
	
	private LocalDateTime css_startdt;
	
	@OneToOne
	private PayCashDeskMove paycashdeskmove;
	
	@ManyToOne
	private PayCashDesk paycashdesk;
	
	@JsonIgnore
	@ManyToOne
	private GenAgent genagent;
	
	@ManyToOne
	private AdmUserProfile userprofile;
	
}
