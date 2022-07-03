package tn.arabsoft.spring.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Caisse

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("paycashdesk")
public class PayCashDesk {

	@Transient
    public static final String SEQUENCE_NAME = "caisses_sequence";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cah_id;
	private String cah_code;
	private String cah_name;
	@Nullable
	private String cah_maxtrans;
	@Nullable
	private int cah_internal;
	
	@DBRef
	private List<PayImpPyMorg> payimppymorg;
	
	
}
