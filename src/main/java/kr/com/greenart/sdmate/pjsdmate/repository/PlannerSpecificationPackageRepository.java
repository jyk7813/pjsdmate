package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;

import java.util.List;

public interface PlannerSpecificationPackageRepository {

    List<PlannerSpecificationPackage> findByMemberNo(int memberNo);

    PlannerSpecificationPackage findBySpecificationNo(int specificationNo);
}
