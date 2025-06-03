package com.cooperativa.votacao.domain.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Voto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private Pauta pauta;
    
    @ManyToOne
    @JoinColumn(name = "associado_id")
    private Associado associado;
    
    private boolean votoFavoravel;
    private LocalDateTime dataVoto;
    
    @PrePersist
    public void prePersist() {
        this.dataVoto = LocalDateTime.now();
    }
} 