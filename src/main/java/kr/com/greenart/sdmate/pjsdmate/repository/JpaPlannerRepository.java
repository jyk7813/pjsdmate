package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaPlannerRepository implements PlannerRepository{

    private final EntityManager em;

    public JpaPlannerRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Planner save(Planner planner) {
        return null;
    }

    @Override
    public Optional<Planner> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<Planner> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Optional<Planner> findByIdAndPwd(String id, String pwd) {
        return Optional.empty();
    }

    @Override
    public Optional<Planner> findByPwd(String pwd) {
        return Optional.empty();
    }

    @Override
    public List<Planner> findAll() {
        return null;
    }
}
