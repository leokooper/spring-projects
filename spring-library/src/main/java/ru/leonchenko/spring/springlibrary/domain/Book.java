package ru.leonchenko.spring.springlibrary.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

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
public class Book {

    public Book(){

    }

    public Book( Long id, String name, Integer pageCount, String isbn, Genre genre, Author author, Integer publisherYear, Publisher publisher, byte[] image, Integer avgRating, Integer totalVoteCount, Integer totalRating, Integer viewCount, String descr) {
        this.id = id;
        this.name = name;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.genre = genre;
        this.author = author;
        this.publisherYear = publisherYear;
        this.publisher = publisher;
        this.image = image;
        this.avgRating = avgRating;
        this.totalVoteCount = totalVoteCount;
        this.totalRating = totalRating;
        this.viewCount = viewCount;
        this.descr = descr;
    }

    public Book(Long id, byte[] content) {
        this.id = id;
        this.content = content;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Column(updatable = false)
    private byte[] content;

    @Column(name = "page_count")
    private Integer pageCount;

    private String isbn;

    @ManyToOne
    @JoinColumn
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Author author;

    @Column(name = "publisher_year")
    private Integer publisherYear;

    @ManyToOne
    @JoinColumn
    private Publisher publisher;

    private byte[] image;

    @Column(name = "avg_rating")
    private Integer avgRating;

    @Column(name = "total_vote_count")
    private Integer totalVoteCount;

    @Column(name = "total_rating")
    private Integer totalRating;

    @Column(name = "view_count")
    private Integer viewCount;

    private String descr;

}
