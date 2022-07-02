package dddpractice.ddd.myshop.order.command.application;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dddpractice.ddd.myshop.order.NoOrderException;
import dddpractice.ddd.myshop.order.command.domain.Order;
import dddpractice.ddd.myshop.order.command.domain.OrderNo;
import dddpractice.ddd.myshop.order.command.domain.OrderRepository;

@Service
public class ChangeShippingService {
	private OrderRepository orderRepository;

	public ChangeShippingService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Transactional
	public void changeShipping(ChangeShippingRequest request) {
		Optional<Order> orderOpt = orderRepository.findById(new OrderNo(request.getNumber()));
		Order order = orderOpt.orElseThrow(NoOrderException::new);

	}
}
