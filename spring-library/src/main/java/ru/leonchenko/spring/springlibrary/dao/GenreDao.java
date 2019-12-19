package ru.leonchenko.spring.springlibrary.dao;

import ru.leonchenko.spring.springlibrary.domain.Author;
import ru.leonchenko.spring.springlibrary.domain.Genre;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface GenreDao {
    List<Genre> getAll();
    Genre get (long id);
    Genre save (Genre obj);
    void delete (Genre obj);

    List<Genre> search(String... searchString);

}
