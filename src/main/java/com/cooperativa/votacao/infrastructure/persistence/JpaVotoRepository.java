package com.cooperativa.votacao.infrastructure.persistence;

import com.cooperativa.votacao.domain.model.Voto;
import com.cooperativa.votacao.domain.ports.VotoRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaVotoRepository extends JpaRepository<Voto, Long>, VotoRepository {
} 