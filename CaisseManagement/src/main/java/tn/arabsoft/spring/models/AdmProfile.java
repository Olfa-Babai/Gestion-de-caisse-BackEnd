package tn.arabsoft.spring.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// profile
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="admprofile")
public class AdmProfile {
	
	@Transient
    public static final String SEQUENCE_NAME = "profiles_sequence";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pru_id;
	private String pru_label;
	@Nullable
	private String pru_status;
	@Enumerated(EnumType.STRING)
	private Role pru_role;
	private LocalDateTime pru_updtprudt;
	@Nullable
	private String pru_natusp;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="profile_aff")
	private List<AdmUserProfile> user_profiles;
	
}
