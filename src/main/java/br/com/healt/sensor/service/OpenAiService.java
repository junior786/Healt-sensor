package br.com.healt.sensor.service;

import br.com.healt.sensor.domain.response.HealtResponse;
import br.com.healt.sensor.integration.OpenAiIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OpenAiService {
    private final OpenAiIntegration integration;

    public Mono<HealtResponse> sendDiagnosis() {

    }

}
