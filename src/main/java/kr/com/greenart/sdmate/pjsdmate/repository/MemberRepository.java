package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member>findById(String id);

    Optional<Member> findByMemberNo(Integer memberNo);

    Optional<Member> findByPhonenum(String phonenum);

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
    @Query("SELECT COUNT(m) FROM Member m WHERE m.phonenum = :phonenum")
    Integer countByPhonenum(String phonenum);
    @Transactional
    @Modifying
    @Query("UPDATE Member m SET m.requirementPk = ?2 WHERE m.memberNo = ?1")
    int updateRequirementPk(int memberPk,int requirementPk);
    @Transactional
    @Modifying
@Query("UPDATE Member m SET m.image =?2 WHERE m.memberNo =?1")
    int updataImage(Integer memberPk,byte[] images);

}