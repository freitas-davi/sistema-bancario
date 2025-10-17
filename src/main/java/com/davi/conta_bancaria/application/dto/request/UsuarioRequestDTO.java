package com.davi.conta_bancaria.application.dto.request;

public record UsuarioRequestDTO (
        String nomeTitular,
        String cpf,
        String email
){}
