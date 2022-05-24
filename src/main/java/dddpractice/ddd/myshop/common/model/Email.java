package dddpractice.ddd.myshop.common.model;

import java.util.Objects;

public class Email {
    private String address;

    public Email(String address) {
        this.address = address;
    }

    public static Email of(String address) {
        return new Email(address);
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Email)) return false;
        Email email = (Email) o;
        return Objects.equals(getAddress(), email.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress());
    }
}