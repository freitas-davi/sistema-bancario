package com.davi.conta_bancaria.controller;

import com.davi.conta_bancaria.application.dto.request.UsuarioRequestDTO;
import com.davi.conta_bancaria.application.dto.response.UsuarioResponseDTO;
import com.davi.conta_bancaria.application.usecase.BuscarUsuarioCpfUseCase;
import com.davi.conta_bancaria.application.usecase.CriarUsuarioUseCase;
import com.davi.conta_bancaria.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final BuscarUsuarioCpfUseCase buscarUsuarioCpfUseCase;

    @Autowired
    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase,
                             BuscarUsuarioCpfUseCase buscarUsuarioCpfUseCase) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.buscarUsuarioCpfUseCase = buscarUsuarioCpfUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> criarUsuario(@RequestBody UsuarioRequestDTO requestDTO) {
        Usuario usuarioCriado = criarUsuarioUseCase.executar(requestDTO);

        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO(
                usuarioCriado.getId(),
                usuarioCriado.getNomeTitular(),
                usuarioCriado.getCpf(),
                usuarioCriado.getEmail()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<UsuarioResponseDTO> buscarCpf(@PathVariable String cpf) {
        UsuarioResponseDTO usuario = buscarUsuarioCpfUseCase.executar(cpf);
        return ResponseEntity.ok(usuario);
    }

}
