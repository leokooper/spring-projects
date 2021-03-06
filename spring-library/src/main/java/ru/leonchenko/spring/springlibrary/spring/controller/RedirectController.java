package ru.leonchenko.spring.springlibrary.spring.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.leonchenko.spring.springlibrary.domain.Author;
import ru.leonchenko.spring.springlibrary.domain.Book;
import ru.leonchenko.spring.springlibrary.spring.repository.AuthorRepository;
import ru.leonchenko.spring.springlibrary.spring.repository.BookRepository;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Controller
@Log
public class RedirectController {
    // при запуске проекта - первый запрос попадает сюда
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String baseUrlRedirect(HttpServletRequest request) {

        // перенаправление на страницу индекс
        return "redirect:" + request.getRequestURL().append("index.xhtml").toString();

    }
}
