package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaRequirementRepository extends JpaRepository<Requirement, Integer>, RequirementRepository {
    @Override
    Optional<Requirement> findByRequirementNo(Integer requirementNo);
}
