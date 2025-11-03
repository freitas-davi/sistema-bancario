package com.davi.conta_bancaria.adapter.out;

import com.davi.conta_bancaria.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean existsByCpf(String cpf);
    Optional<Usuario> findByCpf(String cpf);
}
