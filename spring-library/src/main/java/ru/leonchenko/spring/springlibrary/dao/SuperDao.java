package ru.leonchenko.spring.springlibrary.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import ru.leonchenko.spring.springlibrary.domain.Author;
import ru.leonchenko.spring.springlibrary.domain.Publisher;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public interface SuperDao<T> {

    //получение всех записей (без постраничности)
    List<T> getAll();

    //поиск записей с любым количеством параметров
    List<T> search(String... searchString);

    //получение объекта по id
    T get (long id);

    //обновление существующего объекта (один метод на 2 действия)
    T save (T obj);

    //удаление объекта
    void delete (T obj);

    //получение всех записей с сортировкой результата
    List<T> getAll(Sort sort);

    //получние всех записей с постраничностью
    Page<T> getAll(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection);

    //поиск записей с постраничностью
    Page<T> search(int pageNumber, int pageSize, String sortField, Sort.Direction sortDirection, String... searchString);


}
