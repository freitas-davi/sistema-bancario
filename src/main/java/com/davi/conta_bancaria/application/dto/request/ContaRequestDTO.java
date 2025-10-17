package com.davi.conta_bancaria.application.dto.request;

import java.math.BigDecimal;

public record ContaRequestDTO(
        Long usuarioId,
        BigDecimal saldo
) {}
