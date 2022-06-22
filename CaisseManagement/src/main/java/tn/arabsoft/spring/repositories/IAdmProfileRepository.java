package tn.arabsoft.spring.repositories;

import tn.arabsoft.spring.models.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdmProfileRepository  extends MongoRepository< AdmProfile, Integer> {

}
