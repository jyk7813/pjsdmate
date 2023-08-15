package kr.com.greenart.sdmate.pjsdmate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.domain.PlannerSpecificationPackage;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerSpecificationPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class PlannerService {

    private final PlannerRepository plannerRepository;
    private final ObjectMapper objectMapper;

    private final PlannerSpecificationPackageRepository plannerSpecificationPackageRepository;

    @Autowired
    public PlannerService(PlannerRepository plannerRepository, ObjectMapper objectMapper, PlannerSpecificationPackageRepository plannerSpecificationPackageRepository) {
        this.plannerRepository = plannerRepository;
        this.objectMapper = objectMapper;
        this.plannerSpecificationPackageRepository = plannerSpecificationPackageRepository;
    }


    public Planner getPlannerById(int plannerNo) {
        Planner planner = plannerRepository.findByplannerNo(plannerNo).get();

        return planner;
    }

    public Planner login(String id,String pass){
        Optional<Planner> optionalPlanner = plannerRepository.findById(id);
        Planner planner = null;

        if(optionalPlanner.isPresent()){
           Planner checkPlanner = optionalPlanner.get();
            if(checkPlanner.getPwd().equals(pass)){
                planner =checkPlanner;
                return planner;
            }
        }
            return null;
    }
    public void join(Planner planner){
        planner.setActive(true);
        plannerRepository.save(planner);
    }
    private Planner parseObj(String json){
        Planner planner = null;
        try {
            planner = objectMapper.readValue(json, Planner.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return planner;
    }

    public boolean isEmailDuplicated(String email) {
        Optional<Planner> optionalPlanner = plannerRepository.findByEmail(email);
        if(optionalPlanner.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isIdDuplicated(String id) {
        Optional<Planner> optionalPlanner = plannerRepository.findById(id);
        if(optionalPlanner.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isBusinessNoDuplicated(String businessNo) {
        Optional<Planner> optionalPlanner = plannerRepository.findByBusiness_no(businessNo);
        if (optionalPlanner.isPresent()){
            return true;
        }
        return false;
    }

    public boolean isPhoneNoDuplicated(String phonenum) {
        Optional<Planner> optionalPlanner = plannerRepository.findByphonenum(phonenum);
        if (optionalPlanner.isPresent()){
            return true;
        }
        return false;
    }

    public Planner findBySepcificationInPackage(int specificationNo) {
        Integer plannerPk = plannerSpecificationPackageRepository.findBySpecificationNo(specificationNo).getPlannerNo();
        if (plannerRepository.findByplannerNo(plannerPk).isPresent()) {
            Planner planner = plannerRepository.findByplannerNo(plannerPk).get();
            return planner;
        }

        return null;
    }
    public Planner getPlannerByEmail(String email) {
        Optional<Planner> optionalPlanner = plannerRepository.findByEmail(email);
        Planner planner = null;
        if(optionalPlanner.isPresent()){
            planner = optionalPlanner.get();
        }
        return planner;
    }
    public Planner getPlannerByUsername(String username) {
        Optional<Planner> optionalPlanner = plannerRepository.findById(username);
        Planner planner = null;
        if(optionalPlanner.isPresent()){
            planner = optionalPlanner.get();
        }
        return planner;
    }

    public void updataRating(int rating,int pk){
        PlannerSpecificationPackage packageRepositoryBySpecificationNo = plannerSpecificationPackageRepository.findBySpecificationNo(pk);
        Planner planner = plannerRepository.findByplannerNo(packageRepositoryBySpecificationNo.getPlannerNo()).get();

        double nowRating = planner.getRating();
        int totalRating =(int)nowRating*planner.getDealCnt();
        totalRating= totalRating+rating;

        double updataRating = (double)totalRating/(planner.getDealCnt()+1);

        plannerRepository.updateRating(planner.getPlannerNo(),updataRating,planner.getDealCnt()+1);
    }
    public void updataLastRating(int rating,int pk){
        PlannerSpecificationPackage packageRepositoryBySpecificationNo = plannerSpecificationPackageRepository.findBySpecificationNo(pk);
        Planner planner = plannerRepository.findByplannerNo(packageRepositoryBySpecificationNo.getPlannerNo()).get();

        double nowRating = planner.getRating();
        int totalRating =(int)nowRating*planner.getDealCnt();
        totalRating= totalRating+rating;

        double updataRating = (double)totalRating/(planner.getDealCnt()+1);

        plannerRepository.updateRating(planner.getPlannerNo(),updataRating,planner.getDealCnt());

    }
}
