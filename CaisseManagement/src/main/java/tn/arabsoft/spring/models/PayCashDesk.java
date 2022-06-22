package tn.arabsoft.spring.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Caisse

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("paycashdesk")
public class PayCashDesk {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cah_id;
	private String cah_code;
	private String cah_name;
	private String cah_maxtrans;
	private int cah_internal;
	
	@OneToMany(mappedBy="paycashdesk")
	private List<PayImpPyMorg> payimppymorg;
	
	@OneToMany(mappedBy="paycashdesk")
	private List<PayCashDeskSession> paycashdesksession;
	
}
