package funk.tiago.ScoreMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import funk.tiago.ScoreMaster.model.Club;

public interface ClubRepository extends JpaRepository<Club,Long>{
    List<Club> findByNameContainingIgnoreCase(String name);
}
