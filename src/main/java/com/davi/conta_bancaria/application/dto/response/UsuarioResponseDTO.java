package com.davi.conta_bancaria.application.dto.response;

public record UsuarioResponseDTO (
        Long id,
        String nomeTitular,
        String cpf,
        String email
){}
