package tn.arabsoft.spring.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.format.annotation.DateTimeFormat;
// Facture :

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("gendebt")
public class GenDebt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int deb_id;
	private String deb_refe;
	private String adresse;
	
	@DateTimeFormat(style="yyyy-MM-dd")
	private Date deb_date;

	@DateTimeFormat(style="yyyy-MM-dd")
	private Date deb_duedt;
	
	@DateTimeFormat(style="yyyy-MM-dd")
	private Date deb_printdt;
	
	private int deb_amountinit;
	private String vow_debtype_libelle;
	private int deb_remb;
	private String run_name;
	private String red_name;
	
	// Associations :
	
	@DBRef
	private AgrServiceAgr agrserviceagr;
	
	@DBRef
	private GenOrg genorg;
	
	@DBRef 
	private Party party;
	
	@DBRef
	private GenAccount genaccount;
	
	@DBRef
	private PayCashDebt paycashdebt;
}
