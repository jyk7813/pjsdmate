package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaPlannerSpecificationPackageRepository
    extends JpaRepository<PlannerSpecificationPackage, Integer>, PlannerSpecificationPackageRepository {
    @Override
    List<PlannerSpecificationPackage> findByMemberNo(int memberNo);

    @Override
    List<PlannerSpecificationPackage> findByPlannerNo(int plannerNo);
}
