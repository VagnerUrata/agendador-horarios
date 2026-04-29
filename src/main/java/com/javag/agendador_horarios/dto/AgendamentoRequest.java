package com.javag.agendador_horarios.dto;

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

    @NotBlank(message = "Cliente é obrigatório")
    private String cliente;

    @NotNull
    @Future
    private LocalDateTime dataHoraAgendamento;

    @NotBlank(message = "Serviço é obrigatório")
    private String servico;

    @NotBlank(message = "Profissional é obrigatório")
    private String profissional;

    @NotBlank(message = "Telefone é obrigatório")
    private String telefone;
}
