package crud.crud.repository;

import crud.crud.entity.Todos;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodosRepository extends MongoRepository<Todos, String> {

}
