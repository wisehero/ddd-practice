package dddpractice.ddd.myshop.eventstore.api;

public class PayloadConvertException extends RuntimeException {

	public PayloadConvertException(Exception e) {
		super(e);
	}
}
