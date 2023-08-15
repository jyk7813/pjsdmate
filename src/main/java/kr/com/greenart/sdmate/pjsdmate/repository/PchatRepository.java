package kr.com.greenart.sdmate.pjsdmate.repository;

import kr.com.greenart.sdmate.pjsdmate.domain.Pchat;

import java.util.List;

public interface PchatRepository {
    List<Pchat> findByMemberNoAndPlannerNo(int memberNo, int plannerNo);
}
