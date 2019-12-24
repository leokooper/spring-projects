package ru.leonchenko.spring.springlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ru.leonchenko.spring.springlibrary.dao.BookDao;
import ru.leonchenko.spring.springlibrary.domain.Book;
import ru.leonchenko.spring.springlibrary.spring.repository.BookRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class BookService implements BookDao {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> getAll(Sort sort) {
        return bookRepository.findAll(sort);
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return bookRepository.findAllWithoutContent(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public List<Book> search(String... searchString) {
//        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchString[0],searchString[0]);
        return null;
    }

    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return bookRepository.findByNameContainingIgnoreCaseOrAuthorFioContainingIgnoreCaseOrderByName(searchString[0], searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }


    @Override
    public Book save(Book book) {

        // отдельно сохраняем данные книги
        bookRepository.save(book);

        if (book.getContent()!=null) {
            // отдельно сохраняем контент
            bookRepository.updateContent(book.getContent(), book.getId());
        }

        return book;
    }


    @Override
    public void delete(Book book) {
        bookRepository.delete(book);
    }


    @Override
    public Book get(long id) {
        Optional<Book> bookmark = bookRepository.findById(id); // Optional - обертка, в котором может быть значение или пусто (используется для исключение ошибки NullPointerException
        if (bookmark.isPresent()) { // если значение представлено - вернуть его
            return bookmark.get();
        } else {
            return null;
        }
    }

    public List<Book> findTopBooks(int limit) {
        return bookRepository.findTopBooks(PageRequest.of(0,limit, Sort.by(Sort.Direction.DESC, "viewCount")));
    }

    @Override
    public byte[] getContetnt(long id) {
        return bookRepository.getContent(id);
    }

    @Override
    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
        return bookRepository.findByGenre(genreId, PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

//    @Override
//    public List<Book> findTopBooks(int limit) {
//        return null;
//    }
//
//    @Override
//    public byte[] getContetnt(int id) {
//        return new byte[0];
//    }
//
//    @Override
//    public Page<Book> findByGenre(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, long genreId) {
//        return null;
//    }



}
