package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Mchat;

import java.util.List;

public interface MchatRepository {
    List<Mchat> findByMemberNoAndPlannerNo(int memberNo, int plannerNo);
}
