package ru.leonchenko.spring.springlibrary.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import ru.leonchenko.spring.springlibrary.dao.PublisherDao;
import ru.leonchenko.spring.springlibrary.domain.Genre;
import ru.leonchenko.spring.springlibrary.domain.Publisher;
import ru.leonchenko.spring.springlibrary.spring.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public class PublisherService implements PublisherDao {


    @Autowired
    public PublisherRepository publisherRepository;

    @Override
    public List<Publisher> getAll() {
        return publisherRepository.findAll();
    }

    @Override
    public List<Publisher> search(String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0]);
    }

    @Override
    public Publisher get(long id) {
        Optional<Publisher> bookmark = publisherRepository.findById(id);
        if(bookmark.isPresent()) {
            return bookmark.get();
        } else {
            return null;
        }
    }

    @Override
    public Publisher save(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    @Override
    public void delete(Publisher publisher) {
        publisherRepository.delete(publisher);
    }

    @Override
    public List<Publisher> getAll(Sort sort) {
        return getAll(sort);
    }

    @Override
    public Page<Publisher> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return publisherRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }

    @Override
    public Page<Publisher> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString) {
        return publisherRepository.findByNameContainingIgnoreCaseOrderByName(searchString[0], PageRequest.of(pageNumber, pageSize, Sort.by(sortDirection, sortField)));
    }
}
