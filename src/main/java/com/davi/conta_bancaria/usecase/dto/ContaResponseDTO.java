package com.davi.conta_bancaria.usecase.dto;

import java.math.BigDecimal;

public record ContaResponseDTO(
        Long id,
        String agencia,
        Long numeroConta,
        BigDecimal saldo
) {}
