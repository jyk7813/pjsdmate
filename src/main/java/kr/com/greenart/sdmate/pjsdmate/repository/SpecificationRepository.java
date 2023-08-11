package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Specification;

import java.util.List;
import java.util.Optional;

public interface SpecificationRepository {

    Specification save(Specification specification);

    Optional<Specification> findBySpecificationNo(Integer specificationNo);

    List<Specification> findAll();



}
