package com.marco.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sessao", schema = "votacao")
public class Sessao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pauta_id", referencedColumnName = "id", nullable = false)
    private Pauta pauta;

    @Column(name = "data_criacao", updatable = false)
    private LocalDateTime dataCriacao = LocalDateTime.now();

    @Column(name = "data_fechamento", updatable = false)
    private LocalDateTime dataFechamento;
    @PrePersist
    protected void onCreate() {
        if (dataFechamento == null) {
            this.dataFechamento = this.dataCriacao.plusMinutes(1);
        }
    }

}
