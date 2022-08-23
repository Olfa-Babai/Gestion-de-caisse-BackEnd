package io.getarrays.userservice.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor @Table(name = "paycashdeskmove")
public class PayCashDeskMove {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cam_id;
	private String cam_refe;
	private Date cam_date;
	private int cam_amount;
	private int vom_camtp;
	
	@OneToOne
	private PayCashDeskSession paycashdesksession;
}
