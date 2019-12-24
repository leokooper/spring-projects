package ru.leonchenko.spring.springlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.leonchenko.spring.springlibrary.dao.AuthorDao;
import ru.leonchenko.spring.springlibrary.domain.Author;
import ru.leonchenko.spring.springlibrary.spring.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class AuthorServcie implements AuthorDao {


    @Autowired
    public AuthorRepository authorRepository;

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }


    @Override
    public List<Author> getAll(Sort sort) {
        return authorRepository.findAll(sort);
    }

    @Override
    public Page<Author> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return authorRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Author> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return null;
    }

    @Override
    public List<Author> search(String... searchString) {
        return authorRepository.findByFioContainingIgnoreCaseOrderByFio(searchString[0]);
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        authorRepository.delete(author);
    }

    public Author get(long id) {
        Optional<Author> bookmark = authorRepository.findById(id); // Optional - обертка, в котором может быть значение или пусто (используется для исключение ошибки NullPointerException
        if (bookmark.isPresent()) {  // если значение представлено - вернуть его
            return bookmark.get();
        } else {
            return null;
        }
    }

}
