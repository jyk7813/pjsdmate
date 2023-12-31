package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface RequirementRepository {
    Requirement save(Requirement requirement);

    Optional<Requirement> findByRequirementNo(Integer requirementNo);

    List<Requirement> findAll();

    List<Requirement> findByQ1CityOrderByQ1DateAsc(String q1City);


}
