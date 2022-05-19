package Dao.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orderdetails")
@Getter
@Setter
@RequiredArgsConstructor
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ordered", referencedColumnName = "id")
    private Order orderId;

    @OneToMany
    @JoinColumn(name = "bookid", referencedColumnName = "id")
    private List<Books> bookid;

    @Column
    private int booksCount;

    @Column
    private int cost;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderDetails orderDetails = (OrderDetails) o;
        return id != null && Objects.equals(id, orderDetails.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", bookid=" + bookid +
                ", booksCount=" + booksCount +
                ", cost=" + cost +
                '}';
    }
}