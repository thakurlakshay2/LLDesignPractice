package FlipkartRound1.Service;

import FlipkartRound1.Exceptions.PaymentException;
import FlipkartRound1.Models.DefaultTransactinoFactory;
import FlipkartRound1.Models.Transaction;
import FlipkartRound1.Models.TransactionFactory;
import FlipkartRound1.Models.User;
import FlipkartRound1.Repository.UserRepository;

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
