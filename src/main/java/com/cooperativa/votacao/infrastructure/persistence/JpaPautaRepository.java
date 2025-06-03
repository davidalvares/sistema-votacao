package com.cooperativa.votacao.infrastructure.persistence;

import com.cooperativa.votacao.domain.model.Pauta;
import com.cooperativa.votacao.domain.ports.PautaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaPautaRepository extends JpaRepository<Pauta, Long>, PautaRepository {
} 