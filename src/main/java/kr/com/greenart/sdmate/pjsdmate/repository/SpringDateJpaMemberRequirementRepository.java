package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.MemberRequirement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDateJpaMemberRequirementRepository extends JpaRepository<MemberRequirement,Integer>, MemberRequirementRepository {

    @Override
    MemberRequirement save(MemberRequirement memberRequirement);


    @Override
    Optional<MemberRequirement> findByMemberNo(Integer memberNo);

    @Override
    Optional<MemberRequirement> findByRequirementNo(Integer requirementNo);
}
