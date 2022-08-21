package io.getarrays.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import static javax.persistence.GenerationType.AUTO;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;

/**
 * @author Get Arrays (https://www.getarrays.io/)
 * @version 1.0
 * @since 7/10/2021
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admprofile")
public class Role {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    private String pru_label;
    @Enumerated(EnumType.STRING)
    private Profile name;
    
    @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="profile_aff")
	Collection<AdmUserProfile> user_profile_aff= new ArrayList<>();
    
}
