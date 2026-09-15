package bookstore.bookstorelola.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import bookstore.bookstorelola.domain.BookRepository;
import bookstore.bookstorelola.model.Book;


@Controller 
public class BookController {

    // FIELD NIMELTAAN bookRepository
    private BookRepository bookRepository;
    // CONSTRUCTOR INJECTION
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/index")
    public String showIndex() {
        // VOIDAAN TEHDA TESTI ETTA LOYTYYKO TIETOKANNASTA MITAAN
        // JA TULOSTETAAN CONSOLILLE VSCODEEN SISALTO
        List<Book> bookList = (ArrayList<Book>) bookRepository.findAll();
        return "index";
    }
    
        @RequestMapping("/modify", method=RequestMethod.GET)
    public String modifyBook(@RequestParam String param) {
        return "modifybook";
    }
    
}
