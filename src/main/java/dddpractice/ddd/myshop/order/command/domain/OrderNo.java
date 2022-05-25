package dddpractice.ddd.myshop.order.command.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderNo implements Serializable {

    @Column(name = "order_number")
    private String number;

    protected OrderNo() {

    }

    public OrderNo(String number) {
        this.number = number;
    }

    public static OrderNo of(String number) {
        return new OrderNo(number);
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderNo)) return false;
        OrderNo orderNo = (OrderNo) o;
        return Objects.equals(getNumber(), orderNo.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}