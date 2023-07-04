package br.com.healt.sensor.domain.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class OpenAiResponse {
    private List<ChoicesResponse> choices;
}
