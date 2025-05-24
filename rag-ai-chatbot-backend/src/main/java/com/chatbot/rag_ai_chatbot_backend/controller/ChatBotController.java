package com.chatbot.rag_ai_chatbot_backend.controller;

import com.chatbot.rag_ai_chatbot_backend.dto.QueryDto;
import com.chatbot.rag_ai_chatbot_backend.dto.ResponseDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/api/chat")
public class ChatBotController {

    private final OllamaChatModel ollamaChatModel;
    private final VectorStore vectorStore;

    public ChatBotController(OllamaChatModel ollamaChatModel, VectorStore vectorStore) {
        this.ollamaChatModel = ollamaChatModel;
        this.vectorStore = vectorStore;
    }

    @PostMapping
    public ResponseDto chat(@RequestBody QueryDto queryDto){

        String query = queryDto.getQuery();




        String response = ChatClient.builder(ollamaChatModel)
                .build()
                .prompt()
                .advisors(new QuestionAnswerAdvisor(vectorStore))
                .user(query)
                .call()
                .content();

        return new ResponseDto(response);
    }

}
