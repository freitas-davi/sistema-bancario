package com.davi.conta_bancaria.adapter.in.controller;

import com.davi.conta_bancaria.adapter.in.dto.request.DepositoRequestDTO;
import com.davi.conta_bancaria.adapter.in.dto.request.UsuarioRequestDTO;
import com.davi.conta_bancaria.adapter.in.dto.response.BuscarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.adapter.in.dto.response.ContaResponseDTO;
import com.davi.conta_bancaria.adapter.in.dto.response.CriarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.application.usecase.BuscarUsuarioCpfUseCase;
import com.davi.conta_bancaria.application.usecase.CriarContaUsuarioUseCase;
import com.davi.conta_bancaria.application.usecase.DepositarUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final CriarContaUsuarioUseCase criarContaUsuarioUseCase;
    private final BuscarUsuarioCpfUseCase buscarUsuarioCpfUseCase;
    private final DepositarUseCase depositarUseCase;

    @Autowired
    public UsuarioController(CriarContaUsuarioUseCase criarContaUsuarioUseCase,
                             BuscarUsuarioCpfUseCase buscarUsuarioCpfUseCase,
                             DepositarUseCase depositarUseCase) {
        this.criarContaUsuarioUseCase = criarContaUsuarioUseCase;
        this.buscarUsuarioCpfUseCase = buscarUsuarioCpfUseCase;
        this.depositarUseCase = depositarUseCase;
    }

    @PostMapping
    public ResponseEntity<CriarUsuarioContaResponseDTO> criarUsuario(@RequestBody UsuarioRequestDTO requestDTO) {
        CriarUsuarioContaResponseDTO responseDTO = criarContaUsuarioUseCase.executarCriarUsuario(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<BuscarUsuarioContaResponseDTO> buscarCpf(@PathVariable String cpf) {
        BuscarUsuarioContaResponseDTO usuario = buscarUsuarioCpfUseCase.executarBusca(cpf);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/depositar")
    public ResponseEntity<ContaResponseDTO> depositar(@RequestBody DepositoRequestDTO requestDTO) {
        ContaResponseDTO responseDTO = depositarUseCase.executarDeposito(
                requestDTO.numeroConta(),
                requestDTO.valorDeposito()
        );
        return ResponseEntity.ok(responseDTO);
    }
}
