package Upi_FlipkartRound.Models;

import Upi_FlipkartRound.Exceptions.PaymentException;

public class UpiTransaction  extends Transaction{

    public UpiTransaction(User sender, User receiver, double amount) {
        super(sender, receiver, amount);
    }
    public void process() throws PaymentException {
        validateTransaction();

        BankAccount senderAccount = sender.getPrimaryBankAccount();
        BankAccount receiverAccount = receiver.getPrimaryBankAccount();
        try{
            senderAccount.setBalance( -amount);
            receiverAccount.setBalance(amount);
            status=TransactionStatus.SUCCESS;
        }catch(Exception e){
            status=TransactionStatus.FAILED;
            throw new PaymentException("Insufficient balance");
        }
    }
//    @Override
//    public CompletableFuture<TransactionStatus> processAsync() {
//        return CompletableFuture.supplyAsync(()->{
//            try{
//                validateTransaction();
////                prcessWithRetry();
//                return status;
//            }catch (PaymentException e){
//                updatedStatus(TransactionStatus.FAILED);
//                throw new CompletionException(e);
//
//            }
//        });
//    }

//    private void processWithRetry() throws  PaymentException{
//        while(retryCount<MAX_RETRIES){
//            try{
//                process();
//                return;
//            }catch (PaymentException e){
////                retry++;
//                if(retryCount >=MAX_RETRIES){
//                    throw e;
//                }
//                try{
//                    Thread.sleep(RETRY_DELAY);
//                }
//                catch (InterruptedException e){
//                    Thread.currentThread().interrupt();;
//                   throw  new PaymentException("Transaction Interrupted");
//                }
//            }
//        }
//    }

    private void validateTransaction() throws PaymentException{
        if(!sender.isActive()){
            throw new PaymentException("Sender account is not active");

        }

        if(!receiver.isActive()){
            throw new PaymentException("Receiver account is not active");
        }

        BankAccount senderAccount = sender.getPrimaryBankAccount();
        BankAccount receiverAccount = receiver.getPrimaryBankAccount();

        if( senderAccount == null || receiverAccount==null){
            throw new PaymentException("Primary  account is not found");
        }

        if( !senderAccount.getBank().isServerActive() || !receiverAccount.getBank().isServerActive()){
            throw new PaymentException("Banks not active");
        }

        if(senderAccount.getBalance()<amount){
            throw new PaymentException("Bank Balance Lower than sending Amount");
        }
    }
}
