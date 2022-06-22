package tn.arabsoft.spring.models;

import java.util.List;

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
@Document("genbank")
public class GenBank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ban_id;
	private String ban_code;
	private String ban_name;
	private String ban_bic;
	
	@OneToMany(mappedBy="genbank")
	private List<PayCashing> paycashings;	

}
