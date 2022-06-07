package dddpractice.ddd.myshop.order.query.dao;

import dddpractice.ddd.myshop.order.query.dto.OrderSummary;
import org.springframework.data.repository.Repository;

public interface OrderSummaryDao extends Repository<OrderSummary, String> {

}