package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


public class JpaSpecificationRepository implements SpecificationRepository{
    private final EntityManager em;

    public JpaSpecificationRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Specification save(Specification specification) {
        return null;
    }

    @Override
    public Optional<Specification> findBySpecification_no(Integer specification_no) {
        return Optional.empty();
    }

    @Override
    public List<Specification> findAll() {
        return null;
    }
}
