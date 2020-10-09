package ru.isu.nefrod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.isu.nefrod.model.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
