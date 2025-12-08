package funk.tiago.ScoreMaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import funk.tiago.ScoreMaster.model.Goal;

public interface GoalRepository extends JpaRepository<Goal,Long>{}
