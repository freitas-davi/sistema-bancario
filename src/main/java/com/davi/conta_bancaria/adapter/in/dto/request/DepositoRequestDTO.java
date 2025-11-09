package com.davi.conta_bancaria.adapter.in.dto.request;

import java.math.BigDecimal;

public record DepositoRequestDTO(
        Long numeroConta,
        BigDecimal valorDeposito
) {}
