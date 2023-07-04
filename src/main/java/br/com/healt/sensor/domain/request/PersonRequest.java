package br.com.healt.sensor.domain.request;

public record PersonRequest(
         Double temperature,
         Double oxygenation,
         Double heartbeat,
         Integer year,
         Double height,
         Double weight
) {
}
