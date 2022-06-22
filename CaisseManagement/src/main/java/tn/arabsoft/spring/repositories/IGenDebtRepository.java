package tn.arabsoft.spring.repositories;
import tn.arabsoft.spring.models.GenDebt;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGenDebtRepository extends MongoRepository<GenDebt, Integer> {

}
