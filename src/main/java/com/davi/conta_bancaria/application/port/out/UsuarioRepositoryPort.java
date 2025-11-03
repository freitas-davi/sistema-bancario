package com.davi.conta_bancaria.application.port.out;

import com.davi.conta_bancaria.domain.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    boolean existsByCpf(String cpf);
    Optional<Usuario> findByCpf(String cpf);
    Usuario save(Usuario usuario);
}
