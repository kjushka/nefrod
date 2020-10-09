package ru.isu.nefrod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.nefrod.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
