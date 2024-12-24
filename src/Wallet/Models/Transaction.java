package Wallet.Models;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
    private String transactionId;
    private String fromUserId;
    private String toUserId;
    private BigDecimal amount;
    private LocalDateTime timeStamp;
    private TransactionStatus status;
    private TransactionType type;

    public Transaction(String fromUserId, String toUserId, BigDecimal amount, LocalDateTime timeStamp, TransactionStatus status, TransactionType type) {
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;
        this.timeStamp = timeStamp;
        this.status = status;
        this.type = type;
    }

    public Transaction(String fromUserId, String toUserId, BigDecimal amount) {
        this.transactionId = UUID.randomUUID().toString();
        this.fromUserId = fromUserId;
        this.toUserId = toUserId;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
        this.status = TransactionStatus.SUCCESS;
        this.type = TransactionType.CREDIT;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFromUserId() {
        return fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public TransactionType getType() {
        return type;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

   
}
