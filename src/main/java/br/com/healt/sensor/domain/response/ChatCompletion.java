package br.com.healt.sensor.domain.response;

public record ChatCompletion(
        String id,
        String object,
        long created,
        String model,
        ChatChoice[] choices,
        Usage usage
) {
}

record ChatChoice(
        int index,
        ChatMessage message,
        String finish_reason
) {
}

record ChatMessage(
        String role,
        String content
) {
}

record Usage(
        int prompt_tokens,
        int completion_tokens,
        int total_tokens
) {
}