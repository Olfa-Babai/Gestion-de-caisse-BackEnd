package tn.arabsoft.spring.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Id;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
// Facture :

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gendebt")
public class GenDebt {
	
	@Transient
    public static final String SEQUENCE_NAME = "debts_sequence";
	
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
	
	@ManyToOne
	private AgrServiceAgr contrat;
	
	@ManyToOne
	private GenOrg genorg;
	
	@ManyToOne
	private Party party;
	
	@OneToOne
	private GenAccount genaccount;
	
	@OneToOne
	private PayCashDebt paycashdebt;
}
