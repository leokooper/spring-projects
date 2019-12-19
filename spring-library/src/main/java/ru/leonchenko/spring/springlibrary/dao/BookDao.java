package ru.leonchenko.spring.springlibrary.dao;

import ru.leonchenko.spring.springlibrary.domain.Book;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface BookDao {
    List<Book> getAll();
    Book get (long id);
    Book save (Book obj);
    void delete (Book obj);

    List<Book> search(String... searchString);

    List<Book> findTopBooks(int Limits);
}
