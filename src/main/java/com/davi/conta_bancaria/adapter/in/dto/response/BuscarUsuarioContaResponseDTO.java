package com.davi.conta_bancaria.adapter.in.dto.response;

public record BuscarUsuarioContaResponseDTO(
        Long id,
        String nome,
        String cpf,
        Long numeroConta
) {}
