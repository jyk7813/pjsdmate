package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface SpringDataJpaRequirementRepository extends JpaRepository<Requirement, Integer>, RequirementRepository{
    Requirement save(Requirement requirement);

    Optional<Requirement> findByRequirementNo(Integer requirementNo);
//
    List<Requirement> findByQ1CityOrderByQ1DateAsc(String q1City);


}
