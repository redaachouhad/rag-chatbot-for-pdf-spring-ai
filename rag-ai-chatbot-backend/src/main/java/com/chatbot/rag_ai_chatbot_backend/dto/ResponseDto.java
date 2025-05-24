package com.chatbot.rag_ai_chatbot_backend.dto;

public class ResponseDto {
    private String response;

    public ResponseDto(String response) {
        this.response = response;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
