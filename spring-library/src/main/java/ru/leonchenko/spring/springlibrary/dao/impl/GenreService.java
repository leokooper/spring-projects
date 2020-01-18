package ru.leonchenko.spring.springlibrary.dao.impl;

import org.checkerframework.checker.optional.qual.Present;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.leonchenko.spring.springlibrary.dao.GenreDao;
import ru.leonchenko.spring.springlibrary.domain.Genre;
import ru.leonchenko.spring.springlibrary.spring.repository.GenreRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Service
@Transactional
public class GenreService implements GenreDao {


    @Autowired
    public GenreRepository genreRepository;

    @Override
    public List<Genre> getAll() {
        return genreRepository.findAll();
    }


    @Override
    public List<Genre> search(String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Genre get(long id) {
        Optional<Genre> bookmark = genreRepository.findById(id);
        if(bookmark.isPresent()){
            return bookmark.get();
        } else {
            return null;
        }
    }

    @Override
    public Genre save(Genre genre) {
        return genreRepository.save(genre);
    }

    @Override
    public void delete(Genre genre) {
        genreRepository.delete(genre);
    }

    @Override
    public List<Genre> getAll(Sort sort) {
        return genreRepository.findAll(sort);
    }

    @Override
    public Page<Genre> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return genreRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return genreRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
