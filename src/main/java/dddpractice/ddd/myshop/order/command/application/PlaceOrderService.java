package dddpractice.ddd.myshop.order.command.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dddpractice.ddd.myshop.catalog.command.domain.product.Product;
import dddpractice.ddd.myshop.catalog.command.domain.product.ProductId;
import dddpractice.ddd.myshop.catalog.command.domain.product.ProductRepository;
import dddpractice.ddd.myshop.common.ValidationError;
import dddpractice.ddd.myshop.common.ValidationErrorException;
import dddpractice.ddd.myshop.order.command.domain.OrderLine;
import dddpractice.ddd.myshop.order.command.domain.OrderNo;
import dddpractice.ddd.myshop.order.command.domain.OrderRepository;
import dddpractice.ddd.myshop.order.command.domain.OrderService;
import dddpractice.ddd.myshop.order.command.domain.Orderer;

@Service
public class PlaceOrderService {
	private ProductRepository productRepository;
	private OrderRepository orderRepository;
	private OrdererService orderService;

	public PlaceOrderService(ProductRepository productRepository, OrderRepository orderRepository,
		OrderService orderService) {
		this.productRepository = productRepository;
		this.orderRepository = orderRepository;
		this.orderService = orderService;
	}

	@Transactional
	public OrderNo placeOrder(OrderRequest orderRequest) {
		List<ValidationError> errors = validateOrderRequest(orderRequest);
		if (!errors.isEmpty())
			throw new ValidationErrorException(errors);

		List<OrderLine> orderLines = new ArrayList<>();
		for (OrderProduct op : orderRequest.getOrderProducts()) {
			Optional<Product> productOpt = productRepository.findById(new ProductId(op.getProductId()));
			Product product = productOpt.orElseThrow(() -> new NoOrderProductException(op.getProductId()));
			orderLines.add(new OrderLine(product.getId(), product.getPrice(), op.getQuantity()));
		}

		OrderNo orderNo = orderRepository.nextOrderNo();
		Orderer orderer = ordererService.createOrder
	}

	private List<ValidationError> validateOrderRequest(OrderRequest orderRequest) {
		return new OrderRequestValidator().validate(orderRequest);
	}
}
