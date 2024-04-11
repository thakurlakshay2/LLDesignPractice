package org.MiniWallet.exceptions;

public class WalletAlreadyExist extends  RuntimeException {

    public WalletAlreadyExist() {
        super("Wallet Already exists, cannot create another");
    }
}
