package bookstore.bookstorelola;

import bookstore.bookstorelola.domain.BookTypeRepository;
//Lisää loggerin log-tulostusta varten
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstorelola.model.Book;
import bookstore.bookstorelola.domain.BookType;
import bookstore.bookstorelola.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private final BookTypeRepository bookTypeRepository;
    //Luodaan logger
	private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);

    BookstoreApplication(BookTypeRepository bookTypeRepository) {
        this.bookTypeRepository = bookTypeRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner alustaTietokanta(BookRepository bookRepository) {
		return (parametrit) -> {


			BookType bt = new BookType();
			bt.setMyBookType("audio");
			bookTypeRepository.save(bt);
			

			Book book1 = new Book();
			book1.setTitle("The Chalk Pit");
			book1.setAuthor("Elly Griffiths");
			book1.setIsbn("978-1-78747-036-1");
			book1.setPublicationYear(2017);
			book1.setPrice(15.50);
			book1.setBookType(bt);
			// TALLENNETAAN SE REPOSITORYYN
			bookRepository.save(book1);

			Book book2 = new Book();
			book2.setTitle("The Accordionist");
			book2.setAuthor("Fred Vargas");
			book2.setIsbn("978-1-784-70160-4");
			book2.setPublicationYear(1997);
			book2.setPrice(19.90);

			bookRepository.save(book2);

			Book book3 = new Book();
			book3.setTitle("Titan: The Life of John D. Rockefeller, Sr.");
			book3.setAuthor("Ron Chernow");
			book3.setIsbn("978-0-679-77903-8");
			book3.setPublicationYear(1998);
			book3.setPrice(22.00);

			bookRepository.save(book3);

			Book book4 = new Book();
			book4.setTitle("Steve Jobs");
			book4.setAuthor("Walter Isaacson");
			book4.setIsbn("978-1-4516-4853-9");
			book4.setPublicationYear(2011);
			book4.setPrice(20.00);

			bookRepository.save(book4);

			Book book5 = new Book();
			book5.setTitle("The Snowball: Warren Buffett and the Business of Life");
			book5.setAuthor("Alice Schroeder");
			book5.setIsbn("978-0-553-38496-8");
			book5.setPublicationYear(2008);
			book5.setPrice(18.50);

			bookRepository.save(book5);
			
			bookRepository.findAll().forEach(book ->
				logger.info("Book: {}", book)
        );
		};
	}
}
