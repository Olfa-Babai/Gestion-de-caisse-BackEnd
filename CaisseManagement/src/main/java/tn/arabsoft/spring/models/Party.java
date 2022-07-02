package tn.arabsoft.spring.models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//client

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("party")
public class Party {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int par_id;
	private String par_refe;
	private String par_refe_rxt;
	private String par_name;
	private String address;
	
	@DBRef
	private List<GenAccount> genaccounts;
	
	
}
