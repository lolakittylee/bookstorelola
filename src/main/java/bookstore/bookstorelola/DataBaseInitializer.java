package bookstore.bookstorelola;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import bookstore.bookstorelola.domain.BookRepository;
import bookstore.bookstorelola.model.Book;
import bookstore.bookstorelola.domain.BookType;
import bookstore.bookstorelola.domain.BookTypeRepository;
import bookstore.bookstorelola.domain.Category;
import bookstore.bookstorelola.domain.CategoryRepository;
import bookstore.bookstorelola.domain.AppUser;
import bookstore.bookstorelola.domain.AppUserRepository;

@Configuration
public class DataBaseInitializer {

	@Bean
	public CommandLineRunner initializeDatabase(
			BookRepository bookRepository,
			CategoryRepository categoryRepository,
			AppUserRepository appUserRepository,
			PasswordEncoder passwordEncoder,
			BookTypeRepository booktypeRepository) {
		// lamb-lauseke
		return (args) -> {

			AppUser user1 = new AppUser(
					"user",
					passwordEncoder.encode("user"),
					"user1@haagahelia.fi",
					"ROLE_USER");

			AppUser user2 = new AppUser(
					"admin",
					passwordEncoder.encode("admin"),
					"admin1@haagahelia.fi",
					"ROLE_ADMIN");

			appUserRepository.save(user1);
			appUserRepository.save(user2);

			Category fantasy = categoryRepository.save(new Category("Fantasy"));
			Category romance = categoryRepository.save(new Category("Romance"));

			BookType audio = booktypeRepository.save(new BookType("Audio"));
			BookType paperback = booktypeRepository.save(new BookType("Paperback"));
			BookType ebook = booktypeRepository.save(new BookType("E-book"));

			bookRepository.save(new Book(
					"A Court of Thorns and Roses",
					 "Sarah J. Maas",
					  2015,
					   "1234-56-7",
					    20.00,
						 paperback,
						  fantasy));

			bookRepository.save(new Book(
				"A Court of Mist and Fury",
				"Sarah J. Maas",
				2016,
				"1234-56-8",
				15.00,
				ebook,
				fantasy));

			bookRepository.save(new Book(
				"Icebreaker",
				"Hannah Grace",
				2022,
				"1234-90-1",
				20.00,
				audio,
				romance));			  
		};
	}
}
