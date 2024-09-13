package com.marco.repository;

import com.marco.entity.VotosSessao;
import com.marco.entity.VotosSessaoInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VotosSessaoRepository extends JpaRepository<VotosSessao, Long> {

    @Query(value = "SELECT COUNT(*) as total, voto FROM votacao.votos_sessao WHERE sessao_id = :sessaoId GROUP BY voto", nativeQuery = true)
    List<VotosSessaoInterface> findVotos(@Param("sessaoId") Long sessaoId);

    @Query(value = "SELECT COUNT(*) FROM votacao.votos_sessao WHERE sessao_id = :sessaoId", nativeQuery = true)
    long findTotal(@Param("sessaoId") Long sessaoId);
}