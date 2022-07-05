package dddpractice.ddd.myshop.order.query.application;

import java.util.List;

import dddpractice.ddd.myshop.order.command.domain.Order;
import dddpractice.ddd.myshop.order.command.domain.OrderState;
import dddpractice.ddd.myshop.order.command.domain.Orderer;
import dddpractice.ddd.myshop.order.command.domain.ShippingInfo;

public class OrderDetail {

	private final String number;
	private final Orderer orderer;
	private final ShippingInfo shippingInfo;
	private final OrderState state;
	private final int totalAmounts;
	private final boolean notYetShipped;
	private List<OrderLineDetail> orderLines;
	private long version;

	public OrderDetail(Order order, List<OrderLineDetail> orderLines) {
		this.orderLines = orderLines;
		number = order.getNumber().getNumber();
		version = order.getVersion();
		orderer = order.getOrderer();
		shippingInfo = order.getShippingInfo();
		state = order.getState();
		notYetShipped = order.isNotYetShipped();
		totalAmounts = order.getTotalAmounts().getValue();
	}

	public String getNumber() {
		return number;
	}

	public long getVersion() {
		return version;
	}

	public Orderer getOrderer() {
		return orderer;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public OrderState getState() {
		return state;
	}

	public int getTotalAmounts() {
		return totalAmounts;
	}

	public List<OrderLineDetail> getOrderLines() {
		return orderLines;
	}

	public boolean isNotYetShipped() {
		return notYetShipped;
	}
}
