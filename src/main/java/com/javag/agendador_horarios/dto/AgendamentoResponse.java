package com.javag.agendador_horarios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoResponse {

    private Long id;
    private String cliente;
    private LocalDateTime dataHoraAgendamento;
    private String servico;
}
