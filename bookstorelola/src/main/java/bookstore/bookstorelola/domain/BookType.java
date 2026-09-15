package bookstore.bookstorelola.domain;

import java.util.List;

import bookstore.bookstorelola.model.Book;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class BookType {
    // AUDIO, EBOOK, PAPERBACK
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long booktypeid;
    
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "bookType")
    private List<Book> books;



    private String myBookType;



    public Long getId() {
        return booktypeid;
    }

    public void setId(Long booktypeid) {
        this.booktypeid = booktypeid;
    }

    public String getMyBookType() {
        return myBookType;
    }

    public void setMyBookType(String myBookType) {
        this.myBookType = myBookType;
    }

        public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
