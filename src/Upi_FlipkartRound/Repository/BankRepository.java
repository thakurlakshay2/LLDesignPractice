package Upi_FlipkartRound.Repository;

import Upi_FlipkartRound.Models.Bank;

import java.util.List;
import java.util.Optional;

public interface BankRepository {
    Bank save(Bank bank);
    Optional<Bank> findById(String id);
    Optional<Bank> findByName(String name);
    List<Bank> findAll();
    void delete(String id);


}
