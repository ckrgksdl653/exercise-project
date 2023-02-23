package kr.taehoon.exercise.repository;

import kr.taehoon.exercise.entity.MusculerStrength;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusculerStrengthRepository extends JpaRepository<MusculerStrength, Long> {
}
