package com.davi.conta_bancaria.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class Conta {
    @Id
    @GeneratedValue
    private Long id;
    private String agencia;
    private Long numeroConta;
    private BigDecimal saldo = BigDecimal.ZERO;
    @OneToOne
    private Usuario usuario;

    public void sacar(BigDecimal valor) {
        if(valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor inválido!");
        }
        if(valor.compareTo(saldo) > 0) {
            throw new IllegalArgumentException("Saldo insuficiente!");
        }
        saldo = saldo.subtract(valor);
    }

    public void depositar(BigDecimal valorDeposito) {
        if(valorDeposito.compareTo(BigDecimal.ZERO) <= 0) {
            throw  new IllegalArgumentException("Valor inválido para depósito!");
        }
        saldo = saldo.add(valorDeposito);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Long getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Long numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
