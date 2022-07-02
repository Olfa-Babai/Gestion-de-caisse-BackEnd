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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("paycashing")
public class PayCashing {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int csh_id;
	private int csh_rejet_id;
	private Date csh_date;
	private int sli_id;
	private int csh_amount;
	private int cur_id;
	private String csh_bankdocument;
	private String csh_bank;
	private int vow_rejmotif;
	
	@DBRef
	private GenBank genbank;
	
	
	
}
