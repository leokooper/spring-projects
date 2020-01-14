package ru.leonchenko.spring.springlibrary.jsfui.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

public abstract class AbstractController<T> implements Serializable {

    public abstract Page<T> search(int first, int count, String sortField, Sort.Direction sortDirection);

}
