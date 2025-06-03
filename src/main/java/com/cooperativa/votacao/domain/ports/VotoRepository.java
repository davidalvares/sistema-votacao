package com.cooperativa.votacao.domain.ports;

import com.cooperativa.votacao.domain.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    boolean existsByPautaIdAndAssociado_Id(Long pautaId, Long associadoId);
    List<Voto> findByPautaId(Long pautaId);
} 