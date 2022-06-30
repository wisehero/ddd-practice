package dddpractice.ddd.myshop.order.command.domain;

import dddpractice.ddd.myshop.common.event.Event;

public class OrderCanceledEvent extends Event {

	private String orderNumber;

	public OrderCanceledEvent(String orderNumber) {
		super();
		this.orderNumber = orderNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}
}
