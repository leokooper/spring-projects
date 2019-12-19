package ru.leonchenko.spring.springlibrary.dao;

import ru.leonchenko.spring.springlibrary.domain.Book;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface BookDao extends SuperDao<Book>{

    List<Book> findTopBooks(int Limits);
}
