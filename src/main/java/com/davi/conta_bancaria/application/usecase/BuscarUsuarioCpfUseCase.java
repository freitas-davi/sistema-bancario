package com.davi.conta_bancaria.application.usecase;

import com.davi.conta_bancaria.adapter.in.dto.response.UsuarioResponseDTO;
import com.davi.conta_bancaria.domain.entity.Usuario;
import com.davi.conta_bancaria.adapter.out.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioCpfUseCase {
    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioCpfUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioResponseDTO executar(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf).orElseThrow(()
                -> new RuntimeException("Conta não encontrada!"));

        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getNomeTitular(),
                usuario.getEmail()
        );
    }
}
