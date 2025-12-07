package funk.tiago.ScoreMaster.repository;

import funk.tiago.ScoreMaster.model.Player;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long>{}
