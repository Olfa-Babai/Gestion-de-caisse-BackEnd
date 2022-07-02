package tn.arabsoft.spring.models;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// compte client :

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="genaccount")
public class GenAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int aco_id;
	private int aco_amount;
	
}
