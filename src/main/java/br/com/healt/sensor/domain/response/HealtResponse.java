package br.com.healt.sensor.domain.response;

public record HealtResponse(
        String message,
        Double oxygenation,
        Double heartbeat,
        Double temperature,
        Double imc
) {
}
