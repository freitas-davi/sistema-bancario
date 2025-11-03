package com.davi.conta_bancaria.application.usecase;

import com.davi.conta_bancaria.adapter.in.dto.response.BuscarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.application.port.out.ContaRepositoryPort;
import com.davi.conta_bancaria.application.port.out.UsuarioRepositoryPort;
import com.davi.conta_bancaria.domain.entity.Conta;
import com.davi.conta_bancaria.domain.entity.Usuario;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuarioCpfUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final ContaRepositoryPort contaRepositoryPort;

    public BuscarUsuarioCpfUseCase(UsuarioRepositoryPort usuarioRepositoryPort, 
                                   ContaRepositoryPort contaRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.contaRepositoryPort = contaRepositoryPort;
    }

    public BuscarUsuarioContaResponseDTO executarBusca(String cpf) {
        Usuario usuario = usuarioRepositoryPort.findByCpf(cpf).orElseThrow(()
                -> new RuntimeException("Conta não encontrada!"));

        Conta conta = contaRepositoryPort.findByUsuario(usuario);

        return new BuscarUsuarioContaResponseDTO(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getNomeTitular(),
                conta.getNumeroConta()
        );
    }
}
