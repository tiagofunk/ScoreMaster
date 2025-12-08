package funk.tiago.ScoreMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import funk.tiago.ScoreMaster.model.Card;

public interface CardRepository extends JpaRepository<Card,Long>{}