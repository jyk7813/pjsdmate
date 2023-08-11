package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.MemberRequirement;


import java.util.Optional;

public interface MemberRequirementRepository {
    MemberRequirement save(MemberRequirement memberRequirement);

    Optional<MemberRequirement> findByMemberNo(Integer memberNo);
    Optional<MemberRequirement> findByRequirementNo(Integer requirementNo);
}
