package bookstore.bookstorelola.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bookstore.bookstorelola.model.Book;
import bookstore.bookstorelola.domain.BookRepository;
import bookstore.bookstorelola.domain.BookType;
import bookstore.bookstorelola.domain.BookTypeRepository;
import bookstore.bookstorelola.domain.CategoryRepository;


@Controller
public class BookController {

    // Field nimeltään bookRepository
    private BookRepository bookRepository;
    private BookTypeRepository bookTypeRepository;
    private CategoryRepository categoryRepository;

    // Constructor injection
    public BookController(BookRepository bookRepository,
        BookTypeRepository bookTypeRepository,
         CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.bookTypeRepository = bookTypeRepository;
        this.categoryRepository = categoryRepository;
    }

    /*private BookTypeRepository bookTypeRepository;

    public BookController(BookTypeRepository bookTypeRepository){
        this.bookTypeRepository = bookTypeRepository;
    }*/

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        List<Book> bookList = (ArrayList<Book>) bookRepository.findAll();
        System.out.println(bookList.toString());
        return "index";
    }

    @RequestMapping(value = "/booklist", method = RequestMethod.GET)
    public String showBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        List<Book> books = (List<Book>) bookRepository.findAll();
        for (int i = 0; i < books.size(); i++) {
            BookType bookType = books.get(i).getBookType();
            System.out.println(bookType == null ? null : bookType.getMyBookType());
        }
        return "booklist";
    }

    @RequestMapping(value = "/showmodifyform", method = RequestMethod.POST)
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBook(Book book) {
        bookRepository.save(book);
        return "redirect:booklist";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
        bookRepository.deleteById(bookId);
        return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable ("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));
        return "editBook";
    }




}



