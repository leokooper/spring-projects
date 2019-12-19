package ru.leonchenko.spring.springlibrary.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.leonchenko.spring.springlibrary.domain.Publisher;

import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Long> {

    List<Publisher> findByNameContainingIgnoreCaseOrderByName(String name);

    Page<Publisher> findByNameContainingIgnoreCaseOrderByName(String name, Pageable pageable);

}
