package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Requirement;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaRequirementRepository implements RequirementRepository{
    private final EntityManager em;

    public JpaRequirementRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Requirement save(Requirement requirement) {
        return null;
    }

    @Override
    public Optional<Requirement> findByRequirement_no(Integer requirement_no) {
        return Optional.empty();
    }

    @Override
    public List<Requirement> findAll() {
        return null;
    }
}
