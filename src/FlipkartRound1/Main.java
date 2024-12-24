package FlipkartRound1;

import FlipkartRound1.Models.Bank;
import FlipkartRound1.Models.BankAccount;
import FlipkartRound1.Models.Transaction;
import FlipkartRound1.Models.User;
import FlipkartRound1.Repository.BankRepository;
import FlipkartRound1.Repository.UserRepository;
import FlipkartRound1.Repository.impl.InMemoryBankResository;
import FlipkartRound1.Repository.impl.InMemoryUserRepository;
import FlipkartRound1.Service.PaymentService;


public class Main {
    public static void main(String[] args) {
        try{
            BankRepository bankRepository=new InMemoryBankResository();
            UserRepository userRepository=new InMemoryUserRepository();
            PaymentService paymentService=PaymentService.getInstance(userRepository);

            Bank sbi=new Bank("sbi");
            Bank hdfc=new Bank("hdfc");

            bankRepository.save(sbi);
            bankRepository.save(hdfc);

            for(Bank b: bankRepository.findAll()){
                System.out.println("Created: " + b.getName());
            }

            //Create User
            User.UserBuilder userBuilder=new User.UserBuilder("lakshay","123123123");
            User.UserBuilder userBuilder2=new User.UserBuilder("ut","1242342");
            User.UserBuilder userBuilder3=new User.UserBuilder("user3","98764");

            User u1=new User(userBuilder);
            User u2=new User(userBuilder2);
            User u3=new User(userBuilder3);

            //Store User
            userRepository.save(u1);
            userRepository.save(u2);
            userRepository.save(u3);


            BankAccount b1=new BankAccount("SDI111",sbi,u1);
            BankAccount b1o=new BankAccount("SDI1134",hdfc,u1);
            BankAccount b2=new BankAccount("SDI112",sbi,u2);
            BankAccount b3=new BankAccount("123ee",hdfc,u3);


            userRepository.addBank(u1.getId(),b1);
            userRepository.addBank(u1.getId(),b1o);
            userRepository.addBank(u2.getId(),b2);
            userRepository.addBank(u3.getId(),b3);



            u1.getPrimaryBankAccount().setBalance(1000);
            u1.getPrimaryBankAccount().setBalance(Double.MAX_VALUE);
            u2.getPrimaryBankAccount().setBalance(2000);


            System.out.println(u1.getPrimaryBankAccount().getBalance());
            System.out.println(u2.getPrimaryBankAccount().getBalance());


            paymentService.processPayment(u1,u2,100);
            paymentService.processPayment(u1,u2,50);
            paymentService.processPayment(u1,u2,70);
            paymentService.processPayment(u1,u2,90);
            paymentService.processPayment(u1.getPhoneNumber(),u2.getPhoneNumber(),100);
            paymentService.processPayment(u2.getPhoneNumber(),u1.getPhoneNumber(),178);

            paymentService.processPayment(u1.getPhoneNumber(),u3.getPhoneNumber(),5);

            System.out.println(u1.getPrimaryBankAccount().getBalance());
            System.out.println(u2.getPrimaryBankAccount().getBalance());


            for(Transaction t: paymentService.searchTransaction(u3)){
                System.out.println("Sender: "+t.getSender().getName() + " receiver : "+ t.getReceiver().getName()+" amount: " + t.getAmount()  );
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }
}
