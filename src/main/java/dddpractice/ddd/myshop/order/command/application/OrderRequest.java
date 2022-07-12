package dddpractice.ddd.myshop.order.command.application;

import java.util.List;

import dddpractice.ddd.myshop.member.command.domain.MemberId;
import dddpractice.ddd.myshop.order.command.domain.ShippingInfo;

public class OrderRequest {
	private List<OrderProduct> orderProducts;
	private MemberId ordererMemberId;
	private ShippingInfo shippingInfo;

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}

	public MemberId getOrdererMemberId() {
		return ordererMemberId;
	}

	public void setOrdererMemberId(MemberId ordererMemberId) {
		this.ordererMemberId = ordererMemberId;
	}

	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}

	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
}
