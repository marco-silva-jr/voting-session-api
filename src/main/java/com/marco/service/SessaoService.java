package com.marco.service;

import com.marco.entity.Sessao;
import com.marco.exception.ValidationException;
import com.marco.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessaoService {

    private final SessaoRepository repository;

    @Autowired
    public SessaoService(SessaoRepository repository) {
        this.repository = repository;
    }

    public Sessao save(Sessao sessao) {
        if (sessao.getPauta() == null || sessao.getPauta().getDescricao() == null || sessao.getPauta().getDescricao().trim().isEmpty()) {
            throw new ValidationException("A descrição da pauta não pode ser nula ou vazia.");
        }
        if (sessao.getId() != null) {
            Sessao exists = repository.getById(sessao.getId());
            if (exists != null) {
                throw new ValidationException("Sessão: " + sessao.getId() + " já foi aberta!");
            }
        }
        return repository.save(sessao);
    }

    public Sessao getById(Long id) { return repository.findById(id).orElse(null); }
    public List<Sessao> getAll() { return repository.findAll(); }




}
