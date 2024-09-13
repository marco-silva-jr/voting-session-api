package com.marco.service;

import com.marco.entity.Pauta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.marco.repository.PautaRepository;

import java.util.List;

@Service
public class PautaService {

    private final PautaRepository repository;

    @Autowired
    public PautaService(PautaRepository repository) {
        this.repository = repository;
    }
    public Pauta save(Pauta pauta) {
        if (pauta == null || pauta.getDescricao() == null || pauta.getDescricao().trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição da pauta não pode ser nula ou vazia.");
        }
        return repository.save(pauta);
    }
    public Pauta getById(Long id) { return repository.findById(id).orElse(null); }
    public List<Pauta> getAll() { return repository.findAll(); }

}
