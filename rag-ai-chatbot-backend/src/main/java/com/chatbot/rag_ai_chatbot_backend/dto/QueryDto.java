package com.chatbot.rag_ai_chatbot_backend.dto;

public class QueryDto {
    private String query;

    public String getQuery() {
        return query;
    }

    public QueryDto(String query) {
        this.query = query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
