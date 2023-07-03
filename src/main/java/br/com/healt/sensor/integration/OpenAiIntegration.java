package br.com.healt.sensor.integration;

import br.com.healt.sensor.domain.request.ChatRequest;
import br.com.healt.sensor.domain.response.ChatCompletion;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OpenAiIntegration {
    private WebClient webClient;
    @Value("chatgpt.api.baseUrl")
    private static String BASE_URL;
    @Value("chatgpt.api.key")
    private static String API_KEY;

    private WebClient getWebClient() {
        if (this.webClient == null) {
            return this.webClient = WebClient.builder()
                    .baseUrl(BASE_URL)
                    .defaultHeader("Authorization", String.format("Bearer ", API_KEY))
                    .build();
        }
        return this.webClient;
    }

    public Mono<ChatCompletion> getHealth(ChatRequest request) {
        return this.getWebClient()
                .post()
                .body(Mono.just(request), ChatRequest.class)
                .retrieve()
                .bodyToMono(ChatCompletion.class);
    }


}
