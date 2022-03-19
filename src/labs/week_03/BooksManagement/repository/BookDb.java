package labs.week_03.BooksManagement.repository;

import labs.week_03.BooksManagement.model.Book;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class BookDb implements BookDbInterface {
    private Map<String, Book> db = new ConcurrentHashMap<>();

    @Override
    public Book add(Book book)
    {
        if(this.db.get(book.getId())!=null)
        {
            return null;
        }
        this.db.put(book.getId(), book);
        return book;
    }

    @Override
    public Book read(String id)
    {
        return this.db.get(id);
    }

    @Override
    public Book update(Book book)
    {
        this.db.put(book.getId(), book);
        return book;
    }

    @Override
    public Book remove(String id) {
        return this.db.remove(id);
    }

    @Override
    public void clear()
    {
        this.db.clear();
    }

    @Override
    public List<Book> getAll() {
        return this.db.values().stream().collect(Collectors.toList());
    }
}
