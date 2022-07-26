package tn.arabsoft.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.arabsoft.spring.models.*;

@Repository
public interface IPayCashDebtRepository extends CrudRepository<PayCashDebt, Integer> {

}
