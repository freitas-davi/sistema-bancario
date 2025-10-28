package com.davi.conta_bancaria.application.service;

import com.davi.conta_bancaria.domain.service.ContaFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ContaFactoryTest {
    @Autowired
    private ContaFactory contaFactory;

    @Test
    public void gerarNumero10digitos() {

        Long numeroConta = contaFactory.gerarNumeroConta();

        assertNotNull(String.valueOf(numeroConta), "O número de conta não pode ser nulo");
        assertEquals(10, String.valueOf(numeroConta).length(), "O número de conta deve ter 10 digitos");

    }
}
