package com.davi.conta_bancaria.application.dto.request;

public record UsuarioRequestDTO (
        String cpf,
        String nomeTitular,
        String email
){}
