package com.davi.conta_bancaria.application.usecase;

import com.davi.conta_bancaria.adapter.in.dto.response.BuscarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.adapter.out.ContaRepository;
import com.davi.conta_bancaria.domain.entity.Conta;
import com.davi.conta_bancaria.domain.entity.Usuario;
import com.davi.conta_bancaria.adapter.out.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioCpfUseCase {
    private final UsuarioRepository usuarioRepository;
    private final ContaRepository contaRepository;

    public BuscarUsuarioCpfUseCase(UsuarioRepository usuarioRepository, ContaRepository contaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.contaRepository = contaRepository;
    }

    public BuscarUsuarioContaResponseDTO executarBusca(String cpf) {
        Usuario usuario = usuarioRepository.findByCpf(cpf).orElseThrow(()
                -> new RuntimeException("Conta não encontrada!"));

        Conta conta = contaRepository.findByUsuario(usuario);

        return new BuscarUsuarioContaResponseDTO(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getNomeTitular(),
                conta.getNumeroConta()
        );
    }
}
