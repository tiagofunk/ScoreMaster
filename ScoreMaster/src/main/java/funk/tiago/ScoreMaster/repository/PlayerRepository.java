package funk.tiago.ScoreMaster.repository;

import funk.tiago.ScoreMaster.model.Player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long>{
    List<Player> findByNameContainingIgnoreCase(String name);
}
