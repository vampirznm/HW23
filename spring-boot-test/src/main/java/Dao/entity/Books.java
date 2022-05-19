package Dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "books")
@Getter
@Setter
@RequiredArgsConstructor
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "authorid",referencedColumnName = "id")
    private Authors authorid;

    @Column
    private int releaseYear;

    @Column
    private int pagesNumber;

    @Column
    private double cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Books book = (Books) o;
        return id!= null && Objects.equals(id,book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authorid=" + authorid +
                ", releaseYear=" + releaseYear +
                ", pagesNumber=" + pagesNumber +
                ", cost=" + cost +
                '}';
    }
}