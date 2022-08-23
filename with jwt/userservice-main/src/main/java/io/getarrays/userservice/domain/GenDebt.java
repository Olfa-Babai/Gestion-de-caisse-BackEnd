package io.getarrays.userservice.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "gendebt")
public class GenDebt {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long deb_id;
	private String deb_refe;
	private String adresse;
	
	@DateTimeFormat(style="yyyy-MM-dd")
	private LocalDateTime deb_date;

	@DateTimeFormat(style="yyyy-MM-dd")
	private LocalDateTime deb_duedt;
	
	@DateTimeFormat(style="yyyy-MM-dd")
	private LocalDateTime deb_printdt;
	
	private int deb_amountinit;
	private String vow_debtype_libelle;
	private int deb_remb;
	private String run_name;
	private String red_name;
	
	// Associations :
	
	@JsonIgnore
	@ManyToOne
	private GenOrg genorg;
	
	@ManyToOne
	private Party party;
	
	@JsonIgnore
	@OneToOne
	private GenAccount genaccount;
	
	@OneToOne
	private PayCashDebt paycashdebt;	

}
