package funk.tiago.ScoreMaster.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import funk.tiago.ScoreMaster.model.Stadium;

public interface StadiumRepository extends  JpaRepository<Stadium,Long>{
    List<Stadium> findByNameContainingIgnoreCase(String name);
}