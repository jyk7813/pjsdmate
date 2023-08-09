package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.util.Optional;

@Repository
public interface SpringDataJpaPlannerRepository extends JpaRepository<Planner, Integer>, PlannerRepository {
    @Override
    Optional<Planner> findByplannerNo(Integer plannerNo);

    @Override
    Image getImgfindByplannerNo(Integer plannerNo);
}
