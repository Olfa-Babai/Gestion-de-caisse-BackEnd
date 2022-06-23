package tn.arabsoft.spring.models;

import java.time.LocalDateTime;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// user
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("admuser")
public class AdmUser {

	@Transient
    public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	private int use_id;
	private String use_matricule; // cin ou passeport
	private String use_login;
	private String use_psw;
	private String use_lname;
	private String use_fname;
	private int use_nbessai;
	@Nullable
	private String use_cptestatus;
	private LocalDateTime use_crtdt;
	private LocalDateTime use_lastcnx;
	@Nullable
	private String use_nmadm;
	@Nullable
	private String use_type;
	@Nullable
	private String use_status;
	
	@Nullable
	@ManyToOne
	private AdmUserProfile user_profile;
	
	@Nullable
	@OneToOne(mappedBy="admuser")
	private GenAgent genagent;
	
}
