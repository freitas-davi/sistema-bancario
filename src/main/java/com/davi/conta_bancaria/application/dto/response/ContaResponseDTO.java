package com.davi.conta_bancaria.application.dto.response;

import java.math.BigDecimal;

public record ContaResponseDTO(
        Long id,
        String agencia,
        Long numeroConta,
        BigDecimal saldo
) {}
