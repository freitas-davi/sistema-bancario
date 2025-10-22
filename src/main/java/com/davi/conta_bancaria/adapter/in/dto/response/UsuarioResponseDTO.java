package com.davi.conta_bancaria.adapter.in.dto.response;

public record UsuarioResponseDTO (
        Long id,
        String cpf,
        String nomeTitular,
        String email
){}
