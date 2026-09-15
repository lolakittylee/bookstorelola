package bookstore.bookstorelola.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import bookstore.bookstorelola.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
}

