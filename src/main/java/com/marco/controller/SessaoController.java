package com.marco.controller;

import com.marco.entity.Sessao;
import com.marco.service.SessaoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/sessao")
public class SessaoController {

    private final SessaoService service;
    private static final String ERROR = "error";

    @Autowired
    public SessaoController(SessaoService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/abrir")
    public ResponseEntity<Object> save(@RequestBody Sessao sessao) {
        try {
            // Abrir nova sessao
            Sessao created = service.save(sessao);
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
            // Buscar sessão pelo id
            Sessao sessao = service.getById(id);
            if (sessao != null) {
                return new ResponseEntity<>(sessao, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Nenhum registro encontrado!", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(Map.of(ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        try {
            List<Sessao> list = service.getAll();

            if (list.isEmpty()) {
                return new ResponseEntity<>("Nenhum registro encontrado!", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(Map.of(ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}