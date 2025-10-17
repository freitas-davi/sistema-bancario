package com.davi.conta_bancaria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
public class Conta {
    @Id
    @GeneratedValue
    private Long id;
    private Long numeroConta;
    private BigDecimal saldo = BigDecimal.ZERO;

    @OneToOne
    private Usuario usuario;
}
