package com.davi.conta_bancaria.application.port.out;

import com.davi.conta_bancaria.domain.entity.Conta;
import com.davi.conta_bancaria.domain.entity.Usuario;
import java.util.Optional;

public interface ContaRepositoryPort {
    Optional<Conta> findByNumeroConta(Long numeroConta);
    Conta findByUsuario(Usuario usuario);
    Conta save(Conta conta);
}
