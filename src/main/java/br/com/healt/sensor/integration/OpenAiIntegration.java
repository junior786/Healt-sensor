package br.com.healt.sensor.integration;

import br.com.healt.sensor.domain.request.OpenAiRequest;
import br.com.healt.sensor.domain.response.OpenAiResponse;
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
    @Value("${chatgpt.api.baseUrl}")
    private String BASE_URL;
    @Value("${chatgpt.api.key}")
    private String API_KEY;

    private WebClient getWebClient() {
        System.out.println(API_KEY);
        if (this.webClient == null) {
            return this.webClient = WebClient.builder()
                    .baseUrl(BASE_URL)
                    .defaultHeader("Authorization", "Bearer " + API_KEY)
                    .build();
        }
        return this.webClient;
    }

    public Mono<OpenAiResponse> getHealth(OpenAiRequest request) {

        return this.getWebClient()
                .post()
                .body(Mono.just(request), OpenAiRequest.class)
                .retrieve()
                .bodyToMono(OpenAiResponse.class);
    }


}
