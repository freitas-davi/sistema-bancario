package com.davi.conta_bancaria.adapter.repository;

import com.davi.conta_bancaria.domain.entity.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ContaRepository extends JpaRepository<Conta, Long> {
    Optional<Conta> findByNumeroConta(Long numeroConta);
}