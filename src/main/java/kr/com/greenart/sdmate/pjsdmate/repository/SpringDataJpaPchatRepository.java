package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Pchat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataJpaPchatRepository extends JpaRepository<Pchat, Integer>, PchatRepository {
    @Override
    List<Pchat> findByMemberNoAndPlannerNo(int memberNo, int plannerNo);
}
