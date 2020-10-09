package ru.isu.nefrod.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.isu.nefrod.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
