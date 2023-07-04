package br.com.healt.sensor.domain.mapper;


import br.com.healt.sensor.domain.request.MessageRequest;
import br.com.healt.sensor.domain.request.OpenAiRequest;
import br.com.healt.sensor.domain.request.PersonRequest;
import br.com.healt.sensor.domain.response.HealtResponse;
import br.com.healt.sensor.domain.response.OpenAiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;

@RequiredArgsConstructor
public class ChatMapper {

    @Value("${chatgpt.api.machine}")
    private static String MACHINE;

    public static OpenAiRequest toChatCompletion(String request) {
        return new OpenAiRequest("gpt-3.5-turbo",
                Arrays.asList(new MessageRequest("user", request)));
    }

    public static HealtResponse toResponse(OpenAiResponse response, PersonRequest request, Double imc) {
        return response.getChoices().stream().findFirst()
                .map((it -> new HealtResponse(it.getMessage().getContent(), request.oxygenation(),
                        request.heartbeat(),
                        request.temperature(),
                        imc))).orElseThrow(() -> new RuntimeException("Sem mensagem"));


    }
}
