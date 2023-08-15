package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.awt.*;
import java.util.Optional;

@Repository
public interface SpringDataJpaPlannerRepository extends JpaRepository<Planner, Integer>, PlannerRepository {

    @Override
    Planner save(Planner planner);

    @Override
    Optional<Planner> findByplannerNo(Integer plannerNo);

    @Override
    Optional<Planner> findById(String id);

    @Override
    Optional<Planner> findByIdAndIdentity_no(String name, String identity_no, String id);

    @Override
    Optional<Planner> findByNameAndIdentity_no(String name, String identity_no);

    @Override
    Image getImgfindByplannerNo(Integer plannerNo);
    @Transactional
    @Override
    int updateRating(Integer plannerNo,double rating,int dealCnt);
}
