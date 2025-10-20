package com.davi.conta_bancaria.controller;

import com.davi.conta_bancaria.application.dto.request.UsuarioRequestDTO;
import com.davi.conta_bancaria.application.dto.response.CriarUsuarioContaResponseDTO;
import com.davi.conta_bancaria.application.dto.response.UsuarioResponseDTO;
import com.davi.conta_bancaria.application.usecase.BuscarUsuarioCpfUseCase;
import com.davi.conta_bancaria.application.usecase.CriarContaUsuarioUseCase;
import com.davi.conta_bancaria.model.Usuario;
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
