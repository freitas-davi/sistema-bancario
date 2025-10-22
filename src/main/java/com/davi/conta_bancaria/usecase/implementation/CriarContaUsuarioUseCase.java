package com.davi.conta_bancaria.usecase.implementation;

import com.davi.conta_bancaria.usecase.dto.UsuarioRequestDTO;
import com.davi.conta_bancaria.usecase.dto.ContaResponseDTO;
import com.davi.conta_bancaria.usecase.dto.CriarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.usecase.dto.UsuarioResponseDTO;
import com.davi.conta_bancaria.domain.service.ContaFactory;
import com.davi.conta_bancaria.domain.entity.Conta;
import com.davi.conta_bancaria.domain.entity.Usuario;
import com.davi.conta_bancaria.adapter.repository.ContaRepository;
import com.davi.conta_bancaria.adapter.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;


@Service
public class CriarContaUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;
    private final ContaRepository contaRepository;
    private final ContaFactory contaFactory;
    private static final String NUMERO_AGENCIA = "0022";

    public CriarContaUsuarioUseCase(UsuarioRepository usuarioRepository,
                                    ContaRepository contaRepository,
                                    ContaFactory contaFactory) {
        this.usuarioRepository = usuarioRepository;
        this.contaRepository = contaRepository;
        this.contaFactory = contaFactory;
    }

    @Transactional
    public CriarUsuarioContaResponseDTO executarCriarUsuario(UsuarioRequestDTO requestDTO) {
        if(usuarioRepository.existsByCpf(requestDTO.cpf())) {
            throw new RuntimeException("Usuário com CPF já existente.");
            // FAZER VALIDAÇÃO DE CPF
        }
        Usuario usuario = new Usuario();
        usuario.setCpf(requestDTO.cpf());
        usuario.setNomeTitular(requestDTO.nomeTitular());
        usuario.setEmail(requestDTO.email());
        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        Long numeroConta = contaFactory.gerarNumeroConta();

        Conta conta = new Conta();
        conta.setAgencia(NUMERO_AGENCIA);
        conta.setNumeroConta(numeroConta);
        conta.setSaldo(BigDecimal.ZERO);
        conta.setUsuario(usuario);
        Conta contaSalva = contaRepository.save(conta);

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
