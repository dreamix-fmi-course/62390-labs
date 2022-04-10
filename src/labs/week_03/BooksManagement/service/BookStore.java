package labs.week_03.BooksManagement.service;

import labs.week_03.BooksManagement.model.Book;
import labs.week_03.BooksManagement.repository.BookDb;
import labs.week_03.BooksManagement.repository.BookDbInterface;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store{
    private BookDbInterface db = new BookDb();

    @Override
    public boolean add(Book o) {
        if(this.db.add(o) != null)
        {
            return true;
        }
        return false;
    }

    @Override
    public void remove(Book o) {
        this.db.remove(o.getId());
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author) {
        return this.db.getAll().stream()
                .filter(book ->  book.getAuthor().equals(author))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from) {
        return this.db.getAll().stream()
                .filter(book ->  book.getPublishedYear().isAfter(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to) {
        return this.db.getAll().stream()
                .filter(book -> book.getPublishedYear().isAfter(from))
                .filter(book -> book.getPublishedYear().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public void clear() {
        this.db.clear();
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor() {
        return this.db.getAll().stream()
                .collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher() {
        return this.db.getAll().stream()
                .collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate) {
        return this.db.getAll().stream()
                .filter(bookPredicate)
                .collect(Collectors.toList());
    }
}
