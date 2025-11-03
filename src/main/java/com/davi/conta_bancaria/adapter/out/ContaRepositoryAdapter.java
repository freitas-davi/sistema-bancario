package com.davi.conta_bancaria.adapter.out;

import com.davi.conta_bancaria.application.port.out.ContaRepositoryPort;
import com.davi.conta_bancaria.domain.entity.Conta;
import com.davi.conta_bancaria.domain.entity.Usuario;
import org.springframework.stereotype.Component;
import java.util.Optional;


@Component
public class ContaRepositoryAdapter implements ContaRepositoryPort {

    private final ContaRepository contaRepository;

    public ContaRepositoryAdapter(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public Optional<Conta> findByNumeroConta(Long numeroConta) {
        return contaRepository.findByNumeroConta(numeroConta);
    }

    @Override
    public Conta findByUsuario(Usuario usuario) {
        return contaRepository.findByUsuario(usuario);
    }

    @Override
    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }
}
