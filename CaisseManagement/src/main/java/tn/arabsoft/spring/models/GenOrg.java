package tn.arabsoft.spring.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("genorg")
public class GenOrg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int org_id;
	private String org_name;
	
	@OneToMany(mappedBy="genorg")
	private GenDebt genDebt;
	
}
