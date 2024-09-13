package com.marco.controller;

import com.marco.entity.VotosSessao;
import com.marco.service.VotosSessaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/votos-sessao")
public class VotosSessaoController {

    private final VotosSessaoService service;

    @Autowired
    public VotosSessaoController(VotosSessaoService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/votar")
    public ResponseEntity<?> save(@RequestBody VotosSessao votos) {
        try {
            // Salva o voto do associado
            VotosSessao created = service.save(votos);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id) {
        try {
            // Busca a quantidade de votos por id de sessão
            Long qtd = service.qtdVotos(id);
            return new ResponseEntity<>(qtd, HttpStatus.OK);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}