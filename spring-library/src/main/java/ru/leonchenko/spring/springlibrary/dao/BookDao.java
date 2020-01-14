package ru.leonchenko.spring.springlibrary.dao;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.leonchenko.spring.springlibrary.domain.Book;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


public interface BookDao extends SuperDao<Book>{

    // поиск наиболее популярных книг
    List<Book> findTopBooks(int limit);

    // получение контента по id
    byte[] getContetnt(long id);

    //постраничный вывод книг определенного жанра
    Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId);

    void updateViewCount(long viewCount, long id);

    void updateRating(long totalRating, long totalVoteCount, int avgRating, long id);
}
