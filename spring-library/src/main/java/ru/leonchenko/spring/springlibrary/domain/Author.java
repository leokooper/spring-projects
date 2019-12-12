package ru.leonchenko.spring.springlibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */

@Entity
@Table(catalog = "sping-library")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicUpdate
@DynamicInsert
@SelectBeforeUpdate
public class Author {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String fio;

    private Date birthday;

//    @Basic(fetch = FetchType.LAZY)
//    @ManyToOne
//    private List<Book> books;

    @Override
    public String toString() {
        return fio;
    }
}
