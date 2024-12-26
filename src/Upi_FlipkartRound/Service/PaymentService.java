package Upi_FlipkartRound.Service;

import Upi_FlipkartRound.Exceptions.PaymentException;
import Upi_FlipkartRound.Models.DefaultTransactinoFactory;
import Upi_FlipkartRound.Models.Transaction;
import Upi_FlipkartRound.Models.TransactionFactory;
import Upi_FlipkartRound.Models.User;
import Upi_FlipkartRound.Repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class PaymentService {
    private static PaymentService instance;
    private final TransactionFactory transactionFactory;
    private final List<Transaction> transactionHistory;
    private final UserRepository userRepository;

    private  PaymentService(UserRepository userRepository){
        this.transactionHistory=new ArrayList<>();
        transactionFactory=new DefaultTransactinoFactory();
        this.userRepository=userRepository;
    }
    public static synchronized  PaymentService getInstance(UserRepository userRepository){
        if(instance ==null){
            instance=new PaymentService(userRepository);
        }
        return instance;
    }
    public  void processPayment(User sernde, User receiver , double amount) throws PaymentException{
        Transaction transaction= transactionFactory.createTransaction("UPI",sernde,receiver,amount);

        transaction.process();
;
        transactionHistory.add(transaction);
    }

    public  void processPayment(String senderPhone, String reeceiverPhone , double amount) throws PaymentException{
        User sernde=userRepository.findByPhoneNumber(senderPhone);
        User receiver= userRepository.findByPhoneNumber(reeceiverPhone);
        if(receiver==null || sernde==null){
            throw new PaymentException("user missing");
        }
        Transaction transaction= transactionFactory.createTransaction("UPI",sernde,receiver,amount);

        transaction.process();
        ;
        transactionHistory.add(transaction);
    }
    public List<Transaction> getTransactionHistory(){
        return new ArrayList<>(transactionHistory);

    }
    public List<Transaction> searchTransaction(User user){
        return transactionHistory.stream().filter(t-> t.getSender().equals(user)|| t.getReceiver().equals(user)).toList();
    }

}
