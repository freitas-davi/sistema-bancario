package com.davi.conta_bancaria.usecase.dto;

public record UsuarioResponseDTO (
        Long id,
        String cpf,
        String nomeTitular,
        String email
){}
