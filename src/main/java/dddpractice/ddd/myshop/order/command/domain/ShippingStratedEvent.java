package dddpractice.ddd.myshop.order.command.domain;

public class ShippingStratedEvent {

    private String orderNumber;

    public ShippingStratedEvent(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}