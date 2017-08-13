package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Do My Duyen on 7/27/2017.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
