package dddpractice.ddd.myshop.eventstore;

public class PayloadConvertException extends RuntimeException {

	public PayloadConvertException(Exception e) {
		super(e);
	}
}
