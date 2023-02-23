package kr.taehoon.exercise.repository;

import kr.taehoon.exercise.entity.BackExercise;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BackRepository extends JpaRepository<BackExercise, Long> {
}
