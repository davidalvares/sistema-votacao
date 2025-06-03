package com.cooperativa.votacao.domain.repository;

import com.cooperativa.votacao.domain.model.Associado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<Associado, Long> {
    boolean existsByCpf(String cpf);
} 