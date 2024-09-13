package com.marco.service;

import com.marco.entity.Associado;
import com.marco.exception.ValidationException;
import com.marco.repository.AssociadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssociadoService {

    private final AssociadoRepository repository;
    @Autowired
    public AssociadoService(AssociadoRepository repository ) {
        this.repository = repository;
    }

    public Associado save(Associado associado) {
        if (associado == null) {
            throw new ValidationException("O associado não pode ser nulo.");
        }
        if (associado.getNome() == null || associado.getNome().trim().isEmpty()) {
            throw new ValidationException("O nome do associado não pode ser nulo ou vazio.");
        }
        if (associado.getCpf() == null || associado.getCpf().trim().isEmpty()) {
            throw new ValidationException("O CPF do associado não pode ser nulo ou vazio.");
        }

        return repository.save(associado);
    }

    public Associado getById(Long id) { return repository.findById(id).orElse(null); }
    public List<Associado> getAll() { return repository.findAll(); }




}
