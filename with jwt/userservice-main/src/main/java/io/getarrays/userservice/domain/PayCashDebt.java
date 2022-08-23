package io.getarrays.userservice.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "paycashdebt")
public class PayCashDebt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long pcd_id;
	private Date pcd_date;
	private int pcd_amount;
	
	@OneToOne
	private PayCashDeskMove paycashdeskmove;
	
	@OneToOne
	private GenDebt gendebt;
	
}
