package com.cooperativa.votacao.infrastructure.persistence;

import com.cooperativa.votacao.domain.model.Associado;
import com.cooperativa.votacao.domain.repository.AssociadoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaAssociadoRepository extends JpaRepository<Associado, Long>, AssociadoRepository {
} 