package dddpractice.ddd.myshop.order.command.domain;

public interface CancelPolicy {
	boolean hasCancellationPermission(Order order, Canceller canceller);
}
