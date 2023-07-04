package br.com.healt.sensor.service;

import br.com.healt.sensor.domain.request.PersonRequest;
import org.springframework.stereotype.Service;

@Service
public class CreateMessage {
    public String get(Double imc, PersonRequest request) {
        return """
                    Gere um diagnostico medico curto com esses dados dessa pessoa
                """ + " Ela possui um IMC de " + imc + """
                e sua temperatura corporal esta """ + request.temperature() + """
                 e seus batimentos estão a """ + request.heartbeat() + """
                  e  sua oxigenação esta a """ + request.oxygenation() + """
                 e tem uma altura de """ + request.height() + """
                 e tem um peso de """ + request.weight();

    }
}
