package FlipkartRound1.Models;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Transaction {
    protected final String id;
    protected final User sender;
    protected final User receiver;
    protected final double amount;
    protected TransactionStatus status;
    protected final LocalDateTime createdAt;
    protected LocalDateTime lastUpdated;
    protected int retryCount;
    protected static final int MAX_RETRIES = 3;
    protected static final long RETRY_DELAY = 3000; // 3 seconds
    protected static final long MAX_PENDING_TIME = 120000; // 120 seconds


    public Transaction(User sender, User receiver, double amount) {
        this.id = UUID.randomUUID().toString();
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.status=TransactionStatus.PENDING;
        this.createdAt=LocalDateTime.now();
        this.lastUpdated=this.createdAt;
        this.retryCount=0;
    }

    public void process() {

    }

//    public abstract CompletableFuture<TransactionStatus> processAsync();

    protected  void updatedStatus(TransactionStatus newStatus){
        this.status=newStatus;
        this.lastUpdated=LocalDateTime.now();
    }

    public boolean isPendingTimeout(){
        return status == TransactionStatus.PENDING && Duration.between(createdAt,LocalDateTime.now()).toMillis()>MAX_PENDING_TIME;
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}
