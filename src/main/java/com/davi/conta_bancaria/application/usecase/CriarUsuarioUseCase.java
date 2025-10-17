package com.davi.conta_bancaria.application.usecase;

import com.davi.conta_bancaria.application.dto.request.UsuarioRequestDTO;
import com.davi.conta_bancaria.model.Usuario;
import com.davi.conta_bancaria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class CriarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public CriarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario executar(UsuarioRequestDTO dto) {
        if (usuarioRepository.existsByCpf(dto.cpf())){
            throw new RuntimeException("Esse CPF já está sendo usado por outra conta!");
        }
        Usuario usuario = new Usuario();
        usuario.setNomeTitular(dto.nomeTitular());
        usuario.setCpf(dto.cpf());
        usuario.setEmail(dto.email());

        return usuarioRepository.save(usuario);
    }
}
