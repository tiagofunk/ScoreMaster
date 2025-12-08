package funk.tiago.ScoreMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import funk.tiago.ScoreMaster.model.Game;

public interface GameRepository extends JpaRepository<Game,Long>{}