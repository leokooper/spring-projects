package ru.leonchenko.spring.springlibrary.dao;

import ru.leonchenko.spring.springlibrary.domain.Author;
import ru.leonchenko.spring.springlibrary.domain.Book;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface AuthorDao {

    List<Author> getAll();
    Author get (long id);
    Author save (Author obj);
    void delete (Author obj);

    List<Author> search(String... searchString);

}
