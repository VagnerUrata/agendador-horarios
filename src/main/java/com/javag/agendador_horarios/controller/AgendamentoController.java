package com.javag.agendador_horarios.controller;

import com.javag.agendador_horarios.dto.AgendamentoRequest;
import com.javag.agendador_horarios.dto.AgendamentoResponse;
import com.javag.agendador_horarios.service.AgendamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    @ApiResponse(responseCode = "200", description = "Agendamento criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Erro de validação nos dados")
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")

    @Operation(summary = "Criar um novo agendamento")
    public ResponseEntity<AgendamentoResponse> salvarAgendamento(@RequestBody @Valid AgendamentoRequest request) {
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(request));
    }

    @DeleteMapping
    @Operation(summary = "Deletar agendamento")
    public ResponseEntity<Void> deletarAgendamento(@RequestParam String cliente,
                                                  @RequestParam LocalDateTime dataHoraAgendamento) {

        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Buscar agendamento por data")
    public ResponseEntity<List<AgendamentoResponse>> buscarAgendamentosDoDia(@RequestParam LocalDate data) {
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
    }

    @PutMapping
    @Operation(summary = "Atualizar agendamento")
    public ResponseEntity<AgendamentoResponse> alterarAgendamentos(@RequestBody @Valid AgendamentoRequest request,
                                                                   @RequestParam String cliente,
                                                                   @RequestParam LocalDateTime dataHoraAgendamento) {
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(request, cliente, dataHoraAgendamento));
    }


}
