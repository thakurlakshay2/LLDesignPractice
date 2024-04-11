package org.MiniWallet.exceptions;

public class NegativeBalanceException extends  RuntimeException{
    public NegativeBalanceException() {
        super("Insufficient Balance");
    }
}
