package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlannerService {
    private final PlannerRepository plannerRepository;

    @Autowired
    public PlannerService(PlannerRepository plannerRepository) {
        this.plannerRepository = plannerRepository;
    }

    public Planner getPlannerByPK(int planner_no) {
        Planner planner = plannerRepository.findByplannerNo(planner_no).get();
        return  planner;
    }

}
