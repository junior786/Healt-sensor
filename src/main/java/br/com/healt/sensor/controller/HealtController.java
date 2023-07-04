package br.com.healt.sensor.controller;

import br.com.healt.sensor.domain.request.PersonRequest;
import br.com.healt.sensor.domain.response.HealtResponse;
import br.com.healt.sensor.service.OpenAiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class HealtController {
    private final OpenAiService service;
    @PostMapping("/sensor")
    public Mono<HealtResponse> get( @RequestBody PersonRequest request) {
        return this.service.sendDiagnosis(request);
    }
}
