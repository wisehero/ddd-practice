package dddpractice.ddd.myshop.common.model;

import java.util.Objects;

public class Money {

    private int value;

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    // VO에는 VO만을 위한 로직을 넣을 수 있다.
    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;
        Money money = (Money) o;
        return getValue() == money.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }
}