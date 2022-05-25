package dddpractice.ddd.myshop.lock;

public class LockManagerException extends RuntimeException {
    public LockManagerException(Exception cause) {
        super(cause);
    }
}