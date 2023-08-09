package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(String id);

    Optional<Member> findBymemberNo(Integer memberNo);

    Optional<Member> findByName(String name);

    Optional<Member> findByEmail(String email);

    List<Member> findAll();
    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.identity_no = :identity_no")
    Optional<Member> findByNameAndIdentity_no(String name, String identity_no);

    @Query("SELECT m FROM Member m WHERE m.name = :name AND m.identity_no = :identity_no AND m.id = :id")
    Optional<Member> findByIdAndIdentity_noAndName(String name, String identity_no,String id);


    Optional<Member> findByPwd(String pwd);

    @Query("SELECT COUNT(m) FROM Member m WHERE m.id = :id")
    Integer countById(String id);

    @Query("SELECT COUNT(m) FROM Member m WHERE m.email = :email")
    Integer countByEmail(String email);

    Member findByRequirementPk(int requirementPk);

}