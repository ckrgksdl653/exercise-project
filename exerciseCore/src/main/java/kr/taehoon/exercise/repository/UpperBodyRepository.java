package kr.taehoon.exercise.repository;

import kr.taehoon.exercise.entity.UpperBody;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpperBodyRepository extends JpaRepository<UpperBody, Long> {
}
