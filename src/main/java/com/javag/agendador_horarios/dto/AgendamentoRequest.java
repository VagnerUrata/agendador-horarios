package com.javag.agendador_horarios.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgendamentoRequest {

    @Schema(description = "Nome do cliente", example = "Claudio")
    @NotBlank(message = "Cliente é obrigatório")
    private String cliente;

    @NotNull
    @Schema(example = "2026-05-01T10:00:00")
    @Future(message = "A data deve estar no futuro")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dataHoraAgendamento;

    @Schema(example = "Corte de cabelo")
    @NotBlank(message = "Serviço é obrigatório")
    private String servico;

    @Schema(example = "Jorge")
    @NotBlank(message = "Profissional é obrigatório")
    private String profissional;

    @Schema(example = "11999999999")
    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
}
