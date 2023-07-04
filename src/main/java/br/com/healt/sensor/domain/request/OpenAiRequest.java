package br.com.healt.sensor.domain.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OpenAiRequest {
    private String model;
    private List<MessageRequest> messages;
}
