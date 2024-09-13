package com.marco.repository;

import com.marco.entity.VotosSessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VotosSessaoRepository extends JpaRepository<VotosSessao, Long> {

    @Query(value = "SELECT COUNT(*) FROM votacao.votos_sessao WHERE sessao_id = :sessaoId", nativeQuery = true)
    long count(@Param("sessaoId") Long sessaoId);
}