package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface SpringDataJpaRequirementRepository extends JpaRepository<Requirement, Integer> {
    Requirement save(Requirement requirement);

//    Optional<Requirement> findByrequirementNo(Integer requirement_no);
//
    List<Requirement> findByQ1CityOrderByQ1DateAsc(String q1City);
}
