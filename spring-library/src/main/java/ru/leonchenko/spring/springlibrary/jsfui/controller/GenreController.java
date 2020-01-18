package ru.leonchenko.spring.springlibrary.jsfui.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import ru.leonchenko.spring.springlibrary.dao.GenreDao;
import ru.leonchenko.spring.springlibrary.domain.Genre;
import ru.leonchenko.spring.springlibrary.jsfui.model.LazyDataTable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@ManagedBean
@SessionScoped
@Component
@Getter @Setter
public class GenreController extends AbstractController<Genre>{
    private int rowsCount = 20;
    private int first;

    @Autowired
    private GenreDao genreDao;

    private Genre selectedGenre;

    private LazyDataTable<Genre> lazyModel;

    private Page<Genre> genrePages;


    @PostConstruct
    public void init() {
        lazyModel = new LazyDataTable(this);
    }

    @Override
    public Page<Genre> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        return genrePages;
    }

    public List<Genre> getAll() {
        return genreDao.getAll(Sort.by(Sort.Direction.ASC, "name"));
    }
}
