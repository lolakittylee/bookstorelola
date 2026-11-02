package bookstore.bookstorelola.web;

import java.util.Optional;

//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstorelola.model.Book;
import bookstore.bookstorelola.domain.BookRepository;
//import org.springframework.web.bind.annotation.RequestParam;


@RestController 
public class BookRestController {
    
    private final BookRepository bookRepository;

    public BookRestController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @GetMapping("/books")
    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Optional<Book> findById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }
    
    

}
