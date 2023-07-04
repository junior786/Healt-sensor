package br.com.healt.sensor.service;

import br.com.healt.sensor.domain.mapper.ChatMapper;
import br.com.healt.sensor.domain.request.PersonRequest;
import br.com.healt.sensor.domain.response.HealtResponse;
import br.com.healt.sensor.integration.OpenAiIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OpenAiService {
    private final OpenAiIntegration integration;
    private final CreateMessage createMessage;


    public Mono<HealtResponse> sendDiagnosis(PersonRequest request) {
        var imc = request.weight() / (Math.pow(request.height(), 2)) ;
        return this.integration.
                getHealth(ChatMapper.toChatCompletion(this.createMessage
                        .get(imc, request))).map(it -> ChatMapper.toResponse(it, request, imc));
    }

}
