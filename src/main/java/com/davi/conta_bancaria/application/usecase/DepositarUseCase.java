package com.davi.conta_bancaria.application.usecase;

import com.davi.conta_bancaria.adapter.in.dto.request.DepositoRequestDTO;
import com.davi.conta_bancaria.adapter.in.dto.response.ContaResponseDTO;
import com.davi.conta_bancaria.adapter.out.ContaRepository;
import com.davi.conta_bancaria.domain.entity.Conta;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class DepositarUseCase {
    private final ContaRepository contaRepository;

    public DepositarUseCase(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Transactional
    public ContaResponseDTO executarDeposito(Long numeroConta, BigDecimal valorDeposito) {
        Conta conta = contaRepository.findByNumeroConta(numeroConta)
                .orElseThrow(()-> new RuntimeException("Conta inexistente"));

        conta.depositar(valorDeposito);

        contaRepository.save(conta);

        return new ContaResponseDTO(
                conta.getId(),
                conta.getAgencia(),
                conta.getNumeroConta(),
                conta.getSaldo()
        );
    }
}
