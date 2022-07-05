package dddpractice.ddd.myshop.order.query.application;

import org.springframework.stereotype.Component;

import dddpractice.ddd.myshop.order.command.domain.OrderRepository;

@Component
public class OrderDetailService {
	private OrderRepository orderRepository;
	private ProductQueryService productQueryService;

	public OrderDetailService(OrderRepository orderRepository, ProductQueryService productQueryService) {
		this.orderRepository = orderRepository;
		this.productQueryService = productQueryService;
	}
}
