package com.davi.conta_bancaria.adapter.out;

import com.davi.conta_bancaria.application.port.out.UsuarioRepositoryPort;
import com.davi.conta_bancaria.domain.entity.Usuario;
import org.springframework.stereotype.Component;
import java.util.Optional;


@Component
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;

    public UsuarioRepositoryAdapter(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public boolean existsByCpf(String cpf) {
        return usuarioRepository.existsByCpf(cpf);
    }

    @Override
    public Optional<Usuario> findByCpf(String cpf) {
        return usuarioRepository.findByCpf(cpf);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
