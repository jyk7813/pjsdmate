package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface SpringDataJpaSpecificationRepository extends JpaRepository<Specification, Integer>, SpecificationRepository {
    @Override
    Optional<Specification> findBySpecificationNo(Integer specificationNo);
    @Transactional
    @Override
    int updateState(Integer specificationNo,Integer state);
}
