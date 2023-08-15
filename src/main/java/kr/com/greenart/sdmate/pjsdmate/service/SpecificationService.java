package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;
import kr.com.greenart.sdmate.pjsdmate.domain.Specification;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerSpecificationPackageRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.SpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecificationService {
    private final SpecificationRepository specificationRepository;

    private final PlannerSpecificationPackageRepository plannerSpecificationPackageRepository;



    @Autowired
    public SpecificationService(SpecificationRepository specificationRepository, PlannerSpecificationPackageRepository plannerSpecificationPackageRepository) {
        this.specificationRepository = specificationRepository;
        this.plannerSpecificationPackageRepository = plannerSpecificationPackageRepository;

    }

    public Specification getSpecificationByNo(int specificationNo) {
        Specification specification = specificationRepository.findBySpecificationNo(specificationNo).get();
        return specification;
    }
    public void save(Specification specification, Planner planner, Member member){
        Specification save = specificationRepository.save(specification);

        PlannerSpecificationPackage plannerSpecificationPackage = new PlannerSpecificationPackage();
        plannerSpecificationPackage.setting(plannerSpecificationPackage,save.getSpecificationNo(),planner.getPlannerNo(),member.getMemberNo());

        plannerSpecificationPackageRepository.save(plannerSpecificationPackage);


    }
}
