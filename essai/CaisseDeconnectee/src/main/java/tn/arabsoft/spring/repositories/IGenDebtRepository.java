package tn.arabsoft.spring.repositories;
import tn.arabsoft.spring.models.GenDebt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenDebtRepository extends CrudRepository<GenDebt, Integer> {

}
