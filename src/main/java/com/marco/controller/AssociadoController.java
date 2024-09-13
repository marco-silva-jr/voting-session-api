package com.marco.controller;

import com.marco.entity.Associado;
import com.marco.service.AssociadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/associado")
public class AssociadoController {

    private final AssociadoService service;

    private static final String ERROR = "error";

    @Autowired
    public AssociadoController(AssociadoService service) {
        this.service = service;
    }

    @CrossOrigin
    @PostMapping("/salvar")
    public ResponseEntity<Object> save(@RequestBody Associado associado) {
        try {
            // Salvar novo associado
            Associado created = service.save(associado);
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
            // Buscar associado pelo id
            Associado associado = service.getById(id);
            if (associado != null) {
                return new ResponseEntity<>(associado, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(Map.of("message", "Nenhum registro encontrado!"), HttpStatus.NO_CONTENT);
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
            List<Associado> list = service.getAll();

            if (list.isEmpty()) {
                return new ResponseEntity<>(Map.of("message", "Nenhum registro encontrado!"), HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(list, HttpStatus.OK);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            return new ResponseEntity<>(Map.of(ERROR, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}