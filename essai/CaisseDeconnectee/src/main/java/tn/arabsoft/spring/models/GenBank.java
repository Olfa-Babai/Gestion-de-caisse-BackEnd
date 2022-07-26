package tn.arabsoft.spring.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "genbank")
public class GenBank {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ban_id;
	private String ban_code;
	private String ban_name;
	private String ban_bic;
	
	@OneToMany(mappedBy="genbank")
	List<PayCashing> paycashings;
	
}
