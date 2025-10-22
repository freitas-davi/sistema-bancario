package com.davi.conta_bancaria.usecase.dto;

public record UsuarioRequestDTO (
        String cpf,
        String nomeTitular,
        String email
){}
