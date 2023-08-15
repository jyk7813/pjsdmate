package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Mchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataJpaMchatRepository extends JpaRepository<Mchat, Integer>, MchatRepository {
    @Override
    List<Mchat> findByMemberNoAndPlannerNo(int memberNo, int plannerNo);
}
