package Upi_FlipkartRound.Repository;

import Upi_FlipkartRound.Models.Transaction;
import Upi_FlipkartRound.Models.User;
import Upi_FlipkartRound.dto.TransactionSearchCriteria;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository {
    Transaction save(Transaction transaction);
    Optional<Transaction> findById(String id);
    List<Transaction> findByUser(User user);
    List<Transaction> findBySearchCriteria(TransactionSearchCriteria searchCriteria);
}
