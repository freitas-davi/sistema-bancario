package com.davi.conta_bancaria.application.dto.response;

import java.math.BigDecimal;

public record ContaResponseDTO(
        Long id,
        Long numeroConta,
        BigDecimal saldo,
        Long usuarioId
) {}
