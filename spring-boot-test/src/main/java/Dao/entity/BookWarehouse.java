package Dao.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bookwarehouse")
@Getter
@Setter
@RequiredArgsConstructor
public class BookWarehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JoinColumn(name = "bookid", referencedColumnName = "id")
    private List<Books> bookid;

    @Column
    private int availableBooks;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookWarehouse bookWarehouse = (BookWarehouse) o;
        return id != null && Objects.equals(id, bookWarehouse.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "BookWarehouse{" +
                "id=" + id +
                ", bookid=" + bookid +
                ", availableBooks=" + availableBooks +
                '}';
    }
}