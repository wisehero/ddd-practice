package dddpractice.ddd.myshop.order.command.application;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dddpractice.ddd.myshop.order.NoOrderException;
import dddpractice.ddd.myshop.order.command.domain.CancelPolicy;
import dddpractice.ddd.myshop.order.command.domain.Canceller;
import dddpractice.ddd.myshop.order.command.domain.Order;
import dddpractice.ddd.myshop.order.command.domain.OrderNo;
import dddpractice.ddd.myshop.order.command.domain.OrderRepository;

@Service
public class CancelOrderService {
	private final OrderRepository orderRepository;
	private final CancelPolicy cancelPolicy;

	public CancelOrderService(OrderRepository orderRepository, CancelPolicy cancelPolicy) {
		this.orderRepository = orderRepository;
		this.cancelPolicy = cancelPolicy;
	}

	@Transactional
	public void cancel(OrderNo orderNo, Canceller canceller) {
		Order order = orderRepository.findById(orderNo)
			.orElseThrow(NoOrderException::new);
		if (!cancelPolicy.hasCancellationPermission(order, canceller)) {
			throw new NoCancellablePermission();
		}
		order.cancel();
	}
}
