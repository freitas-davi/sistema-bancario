package com.davi.conta_bancaria.domain.service;

import com.davi.conta_bancaria.adapter.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class ContaFactory {
    @Autowired
    private ContaRepository contaRepository;

    /**
     * Essa classe respresnta um gerador de números
     * Ela gera números de conta únicos e com 10 caracteres.
     */
    public Long gerarNumeroConta() {
        Long numeroConta;
        do {
            long numero = ThreadLocalRandom.current().nextLong(1000000000L, 10000000000L);
            numeroConta = numero;
        } while (contaRepository.findByNumeroConta(numeroConta).isPresent());

        return numeroConta;
    }
}
