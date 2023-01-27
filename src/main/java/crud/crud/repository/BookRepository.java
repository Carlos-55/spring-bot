package crud.crud.repository;

import crud.crud.entity.Books;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Books, String> {

}
