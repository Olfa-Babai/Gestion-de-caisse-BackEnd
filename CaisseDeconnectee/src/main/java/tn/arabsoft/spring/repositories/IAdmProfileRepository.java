package tn.arabsoft.spring.repositories;

import tn.arabsoft.spring.models.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdmProfileRepository  extends CrudRepository< AdmProfile, Integer> {

}
