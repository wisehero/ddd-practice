package dddpractice.ddd.myshop.lock;

public class LockData {

    private String type;
    private String id;
    private String lockId;
    private long timestamp;

    public LockData(String type, String id, String lockId, long timestamp) {
        this.type = type;
        this.id = id;
        this.lockId = lockId;
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getLockId() {
        return lockId;
    }

    public long getTimestamp() {
        return timestamp;
    }

    // 락의 유효시간 판단
    public boolean isExpired() {
        return timestamp < System.currentTimeMillis();
    }
}