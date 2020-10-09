package ru.isu.nefrod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.isu.nefrod.model.Transaction;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {
}
