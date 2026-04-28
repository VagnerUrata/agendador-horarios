package com.javag.agendador_horarios.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String servico;
    @Column(nullable = false)
    private String profissional;
    @Column(nullable = false)
    private LocalDateTime dataHoraAgendamento;
    @Column(nullable = false)
    private String cliente;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false, updatable = false)
    private LocalDateTime dataInsercao;

    @PrePersist
    public void prePersist() {
        this.dataInsercao = LocalDateTime.now();
    }

}
