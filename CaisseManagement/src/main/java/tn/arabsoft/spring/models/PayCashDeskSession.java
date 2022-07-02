package tn.arabsoft.spring.models;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Session caisse

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("paycashdesk")
public class PayCashDeskSession {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int css_id;
	private Date css_enddt;
	
	@DBRef
	private PayCashDesk paycashdesk;
	
	@DBRef
	private AdmUserProfile userprofileaffectation;
	
}
