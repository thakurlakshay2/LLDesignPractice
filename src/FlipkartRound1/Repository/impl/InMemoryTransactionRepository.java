package FlipkartRound1.Repository.impl;

import FlipkartRound1.Models.Transaction;
import FlipkartRound1.Models.User;
import FlipkartRound1.Repository.TransactionRepository;
import FlipkartRound1.dto.TransactionSearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryTransactionRepository implements TransactionRepository {
    private final Map<String, Transaction> transactions=new ConcurrentHashMap<>();
    private final List<Transaction> allTransactions=new ArrayList<>();
    @Override
    public Transaction save(Transaction transaction) {
        return null;
    }

    @Override
    public Optional<Transaction> findById(String id) {
        return Optional.ofNullable(transactions.get(id));
    }

    @Override
    public List<Transaction> findByUser(User user) {
        return allTransactions.stream().filter(t-> t.getSender().equals(user) || t.getReceiver().equals(user)).toList();
    }

    @Override
    public List<Transaction> findBySearchCriteria(TransactionSearchCriteria searchCriteria) {
        return allTransactions.stream().filter(t-> matcheCriteria(t,searchCriteria)).toList();
    }

    private boolean matcheCriteria(Transaction t, TransactionSearchCriteria criteria){
        boolean matches  = true;

//        if(criteria.getStartDate() !=null && criteria.getEndDate()!=null){
//            matches &=
//        }

        return matches;
    }
}
