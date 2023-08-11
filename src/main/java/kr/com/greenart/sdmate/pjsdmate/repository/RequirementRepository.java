package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;

import java.util.List;
import java.util.Optional;

public interface RequirementRepository {
    Requirement save(Requirement requirement);

    Optional<Requirement> findByrequirementNo(Integer requirementNo);

    List<Requirement> findAll();

    List<Requirement> findByQ1CityOrderByQ1DateAsc(String q1City);

}
