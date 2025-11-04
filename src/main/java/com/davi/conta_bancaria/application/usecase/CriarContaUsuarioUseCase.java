package com.davi.conta_bancaria.application.usecase;

import com.davi.conta_bancaria.adapter.in.dto.request.UsuarioRequestDTO;
import com.davi.conta_bancaria.adapter.in.dto.response.ContaResponseDTO;
import com.davi.conta_bancaria.adapter.in.dto.response.CriarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.adapter.in.dto.response.UsuarioResponseDTO;
import com.davi.conta_bancaria.application.port.out.ContaRepositoryPort;
import com.davi.conta_bancaria.application.port.out.UsuarioRepositoryPort;
import com.davi.conta_bancaria.domain.service.ContaFactory;
import com.davi.conta_bancaria.domain.entity.Conta;
import com.davi.conta_bancaria.domain.entity.Usuario;
import com.davi.conta_bancaria.domain.service.CPFValidation;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;


@Service
public class CriarContaUsuarioUseCase {
    private final UsuarioRepositoryPort usuarioRepositoryPort;
    private final ContaRepositoryPort contaRepositoryPort;
    private final ContaFactory contaFactory;
    private static final String NUMERO_AGENCIA = "0022";

    public CriarContaUsuarioUseCase(UsuarioRepositoryPort usuarioRepositoryPort,
                                    ContaRepositoryPort contaRepositoryPort,
                                    ContaFactory contaFactory) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
        this.contaRepositoryPort = contaRepositoryPort;
        this.contaFactory = contaFactory;
    }

    @Transactional
    public CriarUsuarioContaResponseDTO executarCriarUsuario(UsuarioRequestDTO requestDTO) {
        if (!CPFValidation.isCPF(requestDTO.cpf())) {
            throw new RuntimeException("CPF invalido!");
        }

        if (usuarioRepositoryPort.existsByCpf(requestDTO.cpf())) {
            throw new RuntimeException("CPF já existente!");
        }

        Usuario usuario = new Usuario();
        usuario.setCpf(requestDTO.cpf());
        usuario.setNomeTitular(requestDTO.nomeTitular());
        usuario.setEmail(requestDTO.email());
        Usuario usuarioSalvo = usuarioRepositoryPort.save(usuario);

        Long numeroConta = contaFactory.gerarNumeroConta();

        Conta conta = new Conta();
        conta.setAgencia(NUMERO_AGENCIA);
        conta.setNumeroConta(numeroConta);
        conta.setSaldo(BigDecimal.ZERO);
        conta.setUsuario(usuario);
        Conta contaSalva = contaRepositoryPort.save(conta);

        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO(
                usuarioSalvo.getId(),
                usuarioSalvo.getCpf(),
                usuarioSalvo.getNomeTitular(),
                usuarioSalvo.getEmail()
        );
        ContaResponseDTO contaResponseDTO = new ContaResponseDTO(
                contaSalva.getId(),
                contaSalva.getAgencia(),
                contaSalva.getNumeroConta(),
                contaSalva.getSaldo()
        );
        return new CriarUsuarioContaResponseDTO(usuarioResponseDTO, contaResponseDTO);
    }
}
