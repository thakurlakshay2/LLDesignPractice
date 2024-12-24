package FlipkartRound1.Repository;

import FlipkartRound1.Models.Transaction;
import FlipkartRound1.Models.User;
import FlipkartRound1.dto.TransactionSearchCriteria;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(String id);
    List<Transaction> findByUser(User user);
    List<Transaction> findBySearchCriteria(TransactionSearchCriteria searchCriteria);
}
