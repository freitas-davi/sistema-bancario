package com.davi.conta_bancaria.application.dto.response;

public record CriarUsuarioContaResponseDTO(
        UsuarioResponseDTO usuarioResponseDTO,
        ContaResponseDTO contaResponseDTO
) {}
