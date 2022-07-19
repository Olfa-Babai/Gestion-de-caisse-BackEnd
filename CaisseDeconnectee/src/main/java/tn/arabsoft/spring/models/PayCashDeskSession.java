package tn.arabsoft.spring.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
// Session caisse
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "paycashdesksession")
public class PayCashDeskSession {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int css_id;
	private LocalDateTime css_enddt;
	
	private LocalDateTime css_startdt;
	
	@OneToOne
	private PayCashDeskMove paycashdeskmove;
	
	@ManyToOne
	private PayCashDesk paycashdesk;
	
	@ManyToOne
	private GenAgent genagent;
	
	@ManyToOne
	private AdmUserProfile userprofile;
	
}
