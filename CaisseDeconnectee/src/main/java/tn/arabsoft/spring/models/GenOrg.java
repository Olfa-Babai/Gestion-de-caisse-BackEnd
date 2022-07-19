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
@Table(name = "genorg")
public class GenOrg {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int org_id;
	private String org_name;
	
	@OneToMany(mappedBy="genorg")
	List<GenDebt> gendebts;
	
}
