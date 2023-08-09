package kr.com.greenart.sdmate.pjsdmate.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlannerService {

    private final PlannerRepository plannerRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public PlannerService(PlannerRepository plannerRepository, ObjectMapper objectMapper) {
        this.plannerRepository = plannerRepository;
        this.objectMapper = objectMapper;
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
    public void join(String json){
        Planner planner = parseObj(json);

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

}
