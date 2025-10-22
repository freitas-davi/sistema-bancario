package com.davi.conta_bancaria.adapter.in.dto.request;

public record UsuarioRequestDTO (
        String cpf,
        String nomeTitular,
        String email
){}
