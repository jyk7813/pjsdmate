package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;

import java.awt.*;
import java.util.List;
import java.util.Optional;



public interface PlannerRepository {

    // 회원가입때 써야함
    Planner save(Planner planner);
    //플래너 pk로 조회할때 사용함
    Optional<Planner> findByplannerNo(Integer plannerNo);

    // 로그인할때
    Optional<Planner>findById(String id);
    @Query("SELECT p FROM Planner p WHERE p.name = :name AND p.identity_no = :identity_no")
    Optional<Planner>findByNameAndIdentity_no(String name,String identity_no);
    @Query("SELECT p FROM Planner p WHERE p.name=:name AND p.identity_no = :identity_no AND p.id = :id ")
    Optional<Planner> findByIdAndIdentity_no(String name,String identity_no,String id);
    Optional<Planner> findByPwd(String pwd);
    List<Planner> findAll();
    Image getImgfindByplannerNo(Integer plannerNo);
}
