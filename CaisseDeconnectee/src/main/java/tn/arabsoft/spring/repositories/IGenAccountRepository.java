package tn.arabsoft.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.arabsoft.spring.models.*;

@Repository
public interface IGenAccountRepository extends CrudRepository<GenAccount, Integer> {

}
