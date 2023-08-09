package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface PlannerRepository {
    Planner save(Planner planner);
    Optional<Planner> findByEmail(String email);
    Optional<Planner> findByIdAndPwd(String id, String pwd);
    Optional<Planner> findByPwd(String pwd);
    List<Planner> findAll();
    Optional<Planner> findByplannerNo(Integer plannerNo);
    Image getImgfindByplannerNo(Integer plannerNo);
}
