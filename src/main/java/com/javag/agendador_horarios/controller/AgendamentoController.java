package com.javag.agendador_horarios.controller;

import com.javag.agendador_horarios.dto.AgendamentoRequest;
import com.javag.agendador_horarios.dto.AgendamentoResponse;
import com.javag.agendador_horarios.service.AgendamentoService;
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
    public ResponseEntity<AgendamentoResponse> saveAgendamento(@RequestBody @Valid AgendamentoRequest request) {
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAgendamento(@RequestParam String cliente,
                                                  @RequestParam LocalDateTime dataHoraAgendamento) {

        agendamentoService.deletarAgendamento(dataHoraAgendamento, cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> buscarAgendamentosDoDia(@RequestParam LocalDate data) {
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
    }

    @PutMapping
    public ResponseEntity<AgendamentoResponse> alterarAgendamentos(@RequestBody @Valid AgendamentoRequest request,
                                                                   @RequestParam String cliente,
                                                                   @RequestParam LocalDateTime dataHoraAgendamento) {
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(request, cliente, dataHoraAgendamento));
    }
}
