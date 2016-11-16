package pl.akademiakodu.library.dao;

import pl.akademiakodu.library.domain.Book;

import java.util.List;

/**
 * Created by Daniel_B on 16.11.2016.
 */
public interface BookDao {
    void addBook(Book book);
    void removeBook(Book book);
    List<Book> getAllBooks();

}
