package com.marco.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "votos_sessao", schema = "votacao")
public class VotosSessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sessao_id", referencedColumnName = "id", nullable = false)
    private Sessao sessao;

    @ManyToOne
    @JoinColumn(name = "associado_id", referencedColumnName = "id", nullable = false)
    private Associado associado;

    @Column(name = "voto")
    private String voto ;

    @Column(name = "data_voto", updatable = false)
    private LocalDateTime dataVoto = LocalDateTime.now();


}
