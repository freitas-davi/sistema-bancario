package com.davi.conta_bancaria.application.dto.response;

public record UsuarioResponseDTO (
        Long id,
        String cpf,
        String nomeTitular,
        String email
){}
