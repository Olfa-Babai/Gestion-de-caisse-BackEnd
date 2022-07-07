package tn.arabsoft.spring.models;

import org.springframework.data.annotation.Id;
import javax.persistence.Transient;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//mode de reglement

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("payimppymorg")
public class PayImpPyMorg {

	@Transient
    public static final String SEQUENCE_NAME = "reglements_sequence";
	
	@Id
	private int pyim_id;
	@Nullable
	private int pyo_id;
	private String pym_code;
	private String pym_name;
	
	
}
