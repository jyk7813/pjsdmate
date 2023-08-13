package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringDataJpaPlannerSpecificationPackageRepository
    extends JpaRepository<PlannerSpecificationPackage, Integer>, PlannerSpecificationPackageRepository {
    @Override
    List<PlannerSpecificationPackage> findByMemberNo(int memberNo);

    PlannerSpecificationPackage findBySpecificationNo(int specificationNo);
}
