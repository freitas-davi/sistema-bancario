package com.davi.conta_bancaria.adapter.controller;

import com.davi.conta_bancaria.usecase.dto.UsuarioRequestDTO;
import com.davi.conta_bancaria.usecase.dto.CriarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.usecase.dto.UsuarioResponseDTO;
import com.davi.conta_bancaria.usecase.implementation.BuscarUsuarioCpfUseCase;
import com.davi.conta_bancaria.usecase.implementation.CriarContaUsuarioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final CriarContaUsuarioUseCase criarContaUsuarioUseCase;
    private final BuscarUsuarioCpfUseCase buscarUsuarioCpfUseCase;

    @Autowired
    public UsuarioController(CriarContaUsuarioUseCase criarContaUsuarioUseCase,
                             BuscarUsuarioCpfUseCase buscarUsuarioCpfUseCase) {
        this.criarContaUsuarioUseCase = criarContaUsuarioUseCase;
        this.buscarUsuarioCpfUseCase = buscarUsuarioCpfUseCase;
    }

    @PostMapping
    public ResponseEntity<CriarUsuarioContaResponseDTO> criarUsuario(@RequestBody UsuarioRequestDTO requestDTO) {
        CriarUsuarioContaResponseDTO responseDTO = criarContaUsuarioUseCase.executarCriarUsuario(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UsuarioResponseDTO> buscarCpf(@PathVariable String cpf) {
        UsuarioResponseDTO usuario = buscarUsuarioCpfUseCase.executar(cpf);
        return ResponseEntity.ok(usuario);
    }

}
