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
import lombok.Setter;

// Encaissement sur les factures 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paycashdebt")
public class PayCashDebt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pcd_id;
	private Date pcd_date;
	private int pcd_amount;
	
	@OneToOne
	private PayCashDeskMove paycashdeskmove;
	
	@OneToOne
	private GenDebt gendebt;
	
}
