package ru.isu.nefrod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.isu.nefrod.model.Card;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {
}
