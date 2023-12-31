package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.ChatHistory;
import kr.com.greenart.sdmate.pjsdmate.domain.Mchat;
import kr.com.greenart.sdmate.pjsdmate.domain.Pchat;
import kr.com.greenart.sdmate.pjsdmate.repository.MchatRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PchatRepository;
import kr.com.greenart.sdmate.pjsdmate.repository.PlannerSpecificationPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    private final MchatRepository mchatRepository;
    private final PchatRepository pchatRepository;

    private final PlannerSpecificationPackageRepository plannerSpecificationPackageRepository;
    @Autowired
    public ChatService(MchatRepository mchatRepository, PchatRepository pchatRepository, PlannerSpecificationPackageRepository plannerSpecificationPackageRepository) {
        this.mchatRepository = mchatRepository;
        this.pchatRepository = pchatRepository;
        this.plannerSpecificationPackageRepository = plannerSpecificationPackageRepository;
    }

    public void saveMessage(Mchat mchat) {
        mchatRepository.save(mchat);
    }
    public void savePMessage(Pchat pchat) {
        pchatRepository.save(pchat);
    }


    public int returnSpeNo(int memberNo, int plannerNo) {
        return plannerSpecificationPackageRepository.findByMemberNoAndPlannerNo(memberNo, plannerNo).getSpecificationNo();
    }

    public List<ChatHistory> getChatHistory(int memberNo, int plannerNo) {
        List<ChatHistory> histories = new ArrayList<>();

        List<Mchat> mchatList = mchatRepository.findByMemberNoAndPlannerNo(memberNo, plannerNo);
       for (Mchat mchat : mchatList) {
           ChatHistory chatHistory = new ChatHistory();
           chatHistory.setContent(mchat.getContent());
           chatHistory.setWho("M");
           chatHistory.setDatetime(mchat.getDatetime());
           histories.add(chatHistory);
       }
        List<Pchat> pchatList = pchatRepository.findByMemberNoAndPlannerNo(memberNo, plannerNo);
        for (Pchat pchat : pchatList) {
            ChatHistory chatHistory = new ChatHistory();
            chatHistory.setContent(pchat.getContent());
            chatHistory.setWho("P");
            chatHistory.setDatetime(pchat.getDatetime());
            histories.add(chatHistory);
        }
        List<ChatHistory> sortedChatList = histories.stream()
                .sorted(Comparator.comparing(ChatHistory::getDatetime))
                .collect(Collectors.toList());
        return sortedChatList;
    }
}
