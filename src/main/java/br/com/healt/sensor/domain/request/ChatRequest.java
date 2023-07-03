package br.com.healt.sensor.domain.request;

public record ChatRequest(
        String model,
        ChatMessage[] messages
) {}

 record ChatMessage(
        String role,
        String content
) {}