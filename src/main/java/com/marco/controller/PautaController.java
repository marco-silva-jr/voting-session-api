package com.marco.controller;

import com.marco.entity.Pauta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.marco.service.PautaService;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/pauta")
public class PautaController {

    private final PautaService service;

    @Autowired
    public PautaController(PautaService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/salvar")
    public ResponseEntity<?> save(@RequestBody Pauta pauta) {
        try {
            // Salvar nova pauta
            Pauta created = service.save(pauta);
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
            // Buscar pauta pelo id
            Pauta pauta = service.getById(id);
            if (pauta != null) {
                return new ResponseEntity<>(pauta, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Nenhum registro encontrado!", HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @CrossOrigin
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            List<Pauta> list = service.getAll();
            if (list.isEmpty()) {
                return new ResponseEntity<>("Nenhum registro encontrado!", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}