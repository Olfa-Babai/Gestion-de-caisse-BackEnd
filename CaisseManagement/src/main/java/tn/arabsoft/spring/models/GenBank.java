package tn.arabsoft.spring.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("genbank")
public class GenBank {
	
	@Transient
    public static final String SEQUENCE_NAME = "banks_sequence";
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ban_id;
	private String ban_code;
	private String ban_name;
	@Nullable
	private String ban_bic;
}
