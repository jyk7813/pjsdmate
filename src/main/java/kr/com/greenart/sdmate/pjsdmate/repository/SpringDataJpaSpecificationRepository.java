package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaSpecificationRepository extends JpaRepository<Specification, Integer>, SpecificationRepository {
    @Override
    Optional<Specification> findBySpecificationNo(Integer specificationNo);
}
