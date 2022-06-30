package dddpractice.ddd.myshop.order.command.domain;

import dddpractice.ddd.myshop.member.command.domain.MemberId;

public interface OrderService {
	Orderer createOrderer(MemberId ordererMemberId);
}
