package kr.com.greenart.sdmate.pjsdmate.service;

import kr.com.greenart.sdmate.pjsdmate.domain.ChatHistory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ChatServiceTest {

    @Autowired
    ChatService chatService;

    @Test
    void  채팅다가져오기() {
        List<ChatHistory> list = chatService.getChatHistory(1, 1);
        for(ChatHistory elem : list) {
            System.out.println(elem);
        }
    }
}
