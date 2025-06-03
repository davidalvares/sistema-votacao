package com.cooperativa.votacao.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pauta")
@Data
@NoArgsConstructor
public class Pauta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    private LocalDateTime dataCriacao;
    private LocalDateTime inicioSessao;
    private LocalDateTime fimSessao;
    private boolean sessaoAberta;

    public boolean isSessaoAberta() {
        if (!sessaoAberta) {
            return false;
        }
        
        LocalDateTime agora = LocalDateTime.now();
        return inicioSessao != null && 
               fimSessao != null && 
               agora.isAfter(inicioSessao) && 
               agora.isBefore(fimSessao);
    }
} 