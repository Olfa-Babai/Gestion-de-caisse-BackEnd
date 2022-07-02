package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Encaissement sur les factures 

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("paycashdebt")
public class PayCashDebt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pcd_id;
	private Date pcd_date;
	private int pcd_amount;
	
	@DBRef
	private PayCashDeskMove paycashdeskmove;
	
}
