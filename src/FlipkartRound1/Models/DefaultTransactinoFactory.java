package FlipkartRound1.Models;

public class DefaultTransactinoFactory implements TransactionFactory {
    @Override
    public Transaction createTransaction(String type, User sender, User receiver, double amount) {
        if (type.equals("UPI")) {
            System.out.println("Tset case 1");
            return new UpiTransaction(sender, receiver, amount);
        }
        throw new IllegalArgumentException("Invalid transaction type");
    }
}
