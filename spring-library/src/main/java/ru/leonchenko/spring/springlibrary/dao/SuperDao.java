package ru.leonchenko.spring.springlibrary.dao;

import ru.leonchenko.spring.springlibrary.domain.Author;
import ru.leonchenko.spring.springlibrary.domain.Publisher;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface SuperDao<T> {

    List<T> getAll();
    List<T> search(String... searchString);
    T get (long id);
    T save (T obj);
    void delete (T obj);


}
