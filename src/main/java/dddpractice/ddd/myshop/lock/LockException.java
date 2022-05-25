package dddpractice.ddd.myshop.lock;

public class LockException extends RuntimeException {

    public LockException() {
        super();
    }

    public LockException(String message) {
        super(message);
    }

    public LockException(Exception cause) {
        super(cause);
    }
}