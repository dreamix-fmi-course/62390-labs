package labs.week_03.BooksManagement.repository;

import labs.week_03.BooksManagement.model.Book;

import java.util.List;

public interface BookDbInterface {
    Book add(Book book);
    Book read(String id);
    Book update(Book book);
    Book remove(String id);
    void clear();
    List<Book> getAll();
}
