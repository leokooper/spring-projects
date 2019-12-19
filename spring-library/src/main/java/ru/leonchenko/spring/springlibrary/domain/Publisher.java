package ru.leonchenko.spring.springlibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;
import java.util.List;

/**
 * @author Igor Leonchenko
 * @version 1.0
 */


@Entity
@Table(catalog = "sping-library")
@EqualsAndHashCode(of = "id")
@Getter @Setter
@DynamicInsert
@DynamicUpdate
@SelectBeforeUpdate
public class Publisher {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String name;

    @Basic(fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    @Override
    public String toString() {return name;}
}
