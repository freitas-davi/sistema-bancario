package com.davi.conta_bancaria.adapter.in.dto.response;

import java.math.BigDecimal;

public record ContaResponseDTO(
        Long id,
        String agencia,
        Long numeroConta,
        BigDecimal saldo
) {}
