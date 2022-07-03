package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Mouvement session caisse

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("paycashdeskmove")
public class PayCashDeskMove {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cam_id;
	private String cam_refe;
	private Date cam_date;
	private int cam_amount;
	private int vom_camtp;
	
	private PayCashDeskSession paycashdesksession;
	
}
