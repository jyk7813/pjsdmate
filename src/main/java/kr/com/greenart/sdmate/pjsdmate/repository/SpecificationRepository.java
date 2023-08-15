package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface SpecificationRepository {

    Specification save(Specification specification);

    Optional<Specification> findBySpecificationNo(Integer specificationNo);

    List<Specification> findAll();

    @Transactional
    @Modifying
    @Query("UPDATE Specification s SET s.state = ?2 WHERE s.specificationNo = ?1")
    int updateState(Integer specificationNo,Integer state);

}
