package ru.leonchenko.spring.springlibrary.jsfui.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;
import ru.leonchenko.spring.springlibrary.dao.BookDao;
import ru.leonchenko.spring.springlibrary.domain.Book;
import ru.leonchenko.spring.springlibrary.jsfui.enums.SearchType;
import ru.leonchenko.spring.springlibrary.jsfui.model.LazyDataTable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@ManagedBean
@SessionScope
@Component
@Getter @Setter
@Log

public class BookController extends AbstractController<Book> {

    public static final int DEFAULT_PAGE_SIZE=20;

    // из JSF таблицы обязательно должна быть ссылки на переменные, иначе при использовании постраничности dataGrid работает некорректно (не отрабатывает bean)
    // также - выбранное пользователем значение (кол-во записей на странице) будет сохраняться
    private int pageCount = DEFAULT_PAGE_SIZE;


    private SearchType searchType;

    @Autowired
    private BookDao bookDao;

    private LazyDataTable<Book> lazyModel;

    private Page<Book> bookPages;

    @PostConstruct
    public void init(){
        lazyModel = new LazyDataTable<>(this);
    }

    //метод автоматически вызывается из LazyDataTable
    @Override
    public Page<Book> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection) {
        if (sortField == null) {
            sortField = "name";
        }

        if(searchType == null) {
            bookPages = bookDao.getAll(pageNumber, pageSize, sortField, sortDirection);
        } else {
            switch (searchType) {
                case SEARCH_GENRE:
                    break;
                case SEARCH_TEXT:
                    break;
                case ALL:
                    bookPages = bookDao.getAll(pageNumber, pageSize, sortField, sortDirection);
            }
        }
        return bookPages;
    }
}
