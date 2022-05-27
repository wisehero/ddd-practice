package dddpractice.ddd.myshop.order.query.dto;

import dddpractice.ddd.myshop.order.command.domain.OrderState;

public class OrderView {

    private final String number;
    private final OrderState state;
    private final String memberName;
    private final String memberId;
    private final String productName;

    public OrderView(String number, OrderState state, String memberName, String memberId, String productName) {
        this.number = number;
        this.state = state;
        this.memberName = memberName;
        this.memberId = memberId;
        this.productName = productName;
    }

    public String getNumber() {
        return number;
    }

    public OrderState getState() {
        return state;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getProductName() {
        return productName;
    }
}