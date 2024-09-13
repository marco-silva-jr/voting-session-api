package com.marco.controller;

import com.marco.entity.VotosSessao;
import com.marco.entity.VotosSessaoInterface;
import com.marco.service.VotosSessaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/votos-sessao")
public class VotosSessaoController {

    private final VotosSessaoService service;
    private static final String ERROR = "error";

    @Autowired
    public VotosSessaoController(VotosSessaoService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/votar")
    public ResponseEntity<Object> save(@RequestBody VotosSessao votos) {
        try {
            // Salva o voto do associado
            VotosSessao created = service.save(votos);
            return new ResponseEntity<>(created, HttpStatus.CREATED);
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(Map.of(ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Long id) {
        try {
            // Busca a quantidade de votos por id de sessão
            List<VotosSessaoInterface> votos = service.getVotos(id);
            long total = service.getTotal(id);

            // Cria um objeto de resposta para encapsular votos e total
            Map<String, Object> response = new HashMap<>();
            response.put("votos", votos);
            response.put("totalGeral", total);
            response.put("sessao", id);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(Map.of(ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}