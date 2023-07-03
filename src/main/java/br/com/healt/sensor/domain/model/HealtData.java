package br.com.healt.sensor.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HealtData {
    private Double temperature;
    private Double oxygenation;
    private Double heartbeat;
    private Integer year;
    private Double height;
    private Double weight;
    private Double imc;
}
