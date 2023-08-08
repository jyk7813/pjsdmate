package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Integer>, MemberRepository {

    @Override
    Optional<Member> findBymemberNo(Integer memberNo);

    @Override
    Optional<Member> findByName(String name);
}
