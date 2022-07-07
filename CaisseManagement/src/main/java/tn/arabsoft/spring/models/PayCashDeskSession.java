package tn.arabsoft.spring.models;

import java.time.LocalDateTime;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Session caisse

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("paycashdesksession")
public class PayCashDeskSession {

	@Transient
    public static final String SEQUENCE_NAME = "sessions_sequence";
	
	@Id
	private int css_id;
	@Nullable
	private LocalDateTime css_enddt;
	
	private LocalDateTime css_startdt;
	
	private PayCashDesk paycashdesk;
	
	private GenAgent genAgent;
	
	private AdmUserProfile userprofileaffectation;
	
}
