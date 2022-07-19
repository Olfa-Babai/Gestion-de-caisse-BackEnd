package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
// Mouvement session caisse
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paycashdeskmove")
public class PayCashDeskMove {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cam_id;
	private String cam_refe;
	private Date cam_date;
	private int cam_amount;
	private int vom_camtp;
	
	@OneToOne
	private PayCashDeskSession paycashdesksession;
	
}
