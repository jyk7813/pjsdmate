package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;

import java.util.List;

public interface PlannerSpecificationPackageRepository {

    List<PlannerSpecificationPackage> findByMemberNo(int memberNo);
  
    PlannerSpecificationPackage findBySpecificationNo(int specificationNo);
  
    List<PlannerSpecificationPackage> findByPlannerNo(int plannerNo);

    PlannerSpecificationPackage save(PlannerSpecificationPackage plannerSpecificationPackage);

    PlannerSpecificationPackage findByMemberNoAndPlannerNo(int memberNo, int plannerNo);
}
