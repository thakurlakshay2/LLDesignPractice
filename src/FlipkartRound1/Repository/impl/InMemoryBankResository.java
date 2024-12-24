package FlipkartRound1.Repository.impl;

import FlipkartRound1.Models.Bank;
import FlipkartRound1.Repository.BankRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryBankResository implements BankRepository {
    private final Map<String, Bank> banks=new ConcurrentHashMap<>();
    private final Map<String,Bank> nameIndex=new ConcurrentHashMap<>();

    @Override
    public Bank save(Bank bank) {
        if(nameIndex.containsKey(bank.getName())){
            System.out.println("Bank already exist");
        }
        banks.put(bank.getId(),bank);
        nameIndex.put(bank.getName(),bank);
        return null;
    }

    @Override
    public Optional<Bank> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Bank> findByName(String name) {
        return Optional.empty();
    }

    @Override
    public List<Bank> findAll() {
        List<Bank> list = new ArrayList<>(banks.values());

        return list;
    }

    @Override
    public void delete(String id) {

    }


}
