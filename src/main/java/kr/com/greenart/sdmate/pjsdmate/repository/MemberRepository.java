package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);

    Optional<Member> findById(String id);

    Optional<Member> findByEmail(String email);

    List<Member> findAll();

    Optional<Member> findByIdAndPwd(String id, String pwd);

    Optional<Member> findByPwd(String pwd);
}