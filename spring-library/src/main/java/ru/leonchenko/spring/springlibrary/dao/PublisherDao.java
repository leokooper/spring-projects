package ru.leonchenko.spring.springlibrary.dao;

import ru.leonchenko.spring.springlibrary.domain.Book;
import ru.leonchenko.spring.springlibrary.domain.Genre;
import ru.leonchenko.spring.springlibrary.domain.Publisher;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface PublisherDao {
    List<Publisher> getAll();
    Publisher get (long id);
    Publisher save (Genre obj);
    void delete (Publisher obj);

    List<Publisher> search(String... searchString);
}
