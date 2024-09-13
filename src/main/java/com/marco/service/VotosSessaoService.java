package com.marco.service;

import com.marco.entity.VotosSessao;
import com.marco.entity.VotosSessaoInterface;
import com.marco.exception.ValidationException;
import com.marco.repository.VotosSessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VotosSessaoService {

    private final VotosSessaoRepository repository;

    @Autowired
    public VotosSessaoService(VotosSessaoRepository repository) {
        this.repository = repository;
    }
    public VotosSessao save(VotosSessao votos) {
        if (votos.getAssociado() == null) {
            throw new ValidationException("O associado não pode ser nulo.");
        }

        if (votos.getSessao() == null) {
            throw new ValidationException("A Sessão não pode ser nulo.");
        }

        if (votos.getSessao().getPauta() == null) {
            throw new ValidationException("A Pauta não pode ser nulo.");
        }

        if (votos.getVoto() == null) {
            throw new ValidationException("O Voto não pode ser nulo.");
        }
        if (!votos.getVoto().equalsIgnoreCase("SIM") && !votos.getVoto().equalsIgnoreCase("NAO") ) {
            throw new ValidationException("O Voto não pode ser diferente de SIM/NAO.");
        }

        if (votos.getSessao().getDataFechamento().isBefore(LocalDateTime.now())) {
            throw new ValidationException("A sessão já foi encerrada. Não é possível registrar o voto.");
        }

        return repository.save(votos);
    }
    public List<VotosSessaoInterface> getVotos(Long sessaoId) {
        return repository.findVotos(sessaoId);
    }
    public long getTotal(Long sessaoId) {
        return repository.findTotal(sessaoId);
    }

    public List<VotosSessao> getAll() { return repository.findAll(); }

}
