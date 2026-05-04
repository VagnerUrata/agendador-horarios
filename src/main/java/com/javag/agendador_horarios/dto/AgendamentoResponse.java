package com.javag.agendador_horarios.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoResponse {

    private Long id;
    @Schema(example = "Claudio")
    private String cliente;
    @Schema(example = "2026-05-01T10:00:00")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataHoraAgendamento;
    @Schema(example = "Corte de cabelo")
    private String servico;
    @Schema(example = "Jorge")
    private String profissional;
    @Schema(example = "11999999999")
    private String telefone;
}
