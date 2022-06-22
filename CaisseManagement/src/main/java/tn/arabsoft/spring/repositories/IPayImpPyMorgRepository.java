package tn.arabsoft.spring.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import tn.arabsoft.spring.models.*;

@Repository
public interface IPayImpPyMorgRepository extends MongoRepository<PayImpPyMorg, Integer> {

}
