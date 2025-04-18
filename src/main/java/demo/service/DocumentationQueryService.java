package demo.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class DocumentationQueryService {
    private final ChatClient chatClient;

    public DocumentationQueryService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String ask(){

        String prompt = "Based on the following website content: Answer this question:";
        String answer = chatClient.prompt()
                .user(prompt)
                .call()
                .content();
        return answer;
    }
}
