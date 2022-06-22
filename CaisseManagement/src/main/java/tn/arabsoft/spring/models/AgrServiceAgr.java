package tn.arabsoft.spring.models;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// contrat
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("agrserviceagr")
public class AgrServiceAgr {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sag_id;
	private String sag_refe;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="agrserviceagr")
	private List<GenDebt> gendebts;	
	
}
