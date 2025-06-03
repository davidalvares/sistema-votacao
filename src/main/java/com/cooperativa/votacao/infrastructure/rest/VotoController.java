package com.cooperativa.votacao.infrastructure.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooperativa.votacao.application.dto.RegistrarVotoRequest;
import com.cooperativa.votacao.application.service.VotoService;
import com.cooperativa.votacao.application.service.VotoService.ResultadoVotacao;
import com.cooperativa.votacao.domain.model.Voto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/votos")
@RequiredArgsConstructor
public class VotoController {
    
    private final VotoService votoService;
    
    @PostMapping
    public ResponseEntity<Voto> registrarVoto(@Valid @RequestBody RegistrarVotoRequest request) {
        return ResponseEntity.ok(votoService.registrarVoto(request));
    }
    
    @GetMapping("/resultado/{pautaId}")
    public ResponseEntity<ResultadoVotacao> obterResultado(@PathVariable Long pautaId) {
        return ResponseEntity.ok(votoService.obterResultado(pautaId));
    }
}