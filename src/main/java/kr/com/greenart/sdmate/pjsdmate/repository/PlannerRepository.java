package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Planner;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
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

    //join
    @Query("SELECT p FROM Planner p WHERE p.phonenum = :phonenum")
    Optional<Planner> findByphonenum(String phonenum);

    @Query("SELECT p FROM Planner p WHERE p.business_no = :business_no")
    Optional<Planner> findByBusiness_no(String business_no);

    @Query("SELECT p FROM Planner p WHERE p.email = :email")
    Optional<Planner> findByEmail(String email);
    //update


    @Transactional
    @Modifying
    @Query("UPDATE Planner p SET p.rating = ?2, p.dealCnt = ?3 WHERE p.plannerNo = ?1")
    int updateRating(Integer plannerNo,double rating,int dealCnt);



}
