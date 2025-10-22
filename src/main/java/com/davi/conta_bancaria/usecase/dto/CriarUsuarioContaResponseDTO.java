package com.davi.conta_bancaria.usecase.dto;

public record CriarUsuarioContaResponseDTO(
        UsuarioResponseDTO usuarioResponseDTO,
        ContaResponseDTO contaResponseDTO
) {}
