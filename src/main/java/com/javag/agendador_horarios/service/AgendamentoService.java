package com.javag.agendador_horarios.service;

import com.javag.agendador_horarios.dto.AgendamentoRequest;
import com.javag.agendador_horarios.dto.AgendamentoResponse;
import com.javag.agendador_horarios.exception.AgendamentoException;
import com.javag.agendador_horarios.infrastructure.entity.Agendamento;
import com.javag.agendador_horarios.infrastructure.repository.AgendamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoResponse salvarAgendamento(AgendamentoRequest request) {
        Agendamento agendamento = toEntity(request);

        LocalDateTime inicio = agendamento.getDataHoraAgendamento();
        LocalDateTime fim = inicio.plusHours(1);

        Agendamento conflito = agendamentoRepository.findByServicoAndDataHoraAgendamentoBetween(agendamento.getServico(), inicio, fim);

        if (conflito != null) {
            throw new AgendamentoException("Horário já está preenchido");
        }

        Agendamento salvo = agendamentoRepository.save(agendamento);

        return toResponse(salvo);
    }

    public void deletarAgendamento(LocalDateTime dataHoraAgendamento, String cliente) {
        agendamentoRepository.deleteByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);
    }

    public List<AgendamentoResponse> buscarAgendamentosDia(LocalDate data) {
        LocalDateTime inicio = data.atStartOfDay();
        LocalDateTime fim = data.atTime(23, 59, 59);

        List<Agendamento> lista = agendamentoRepository.findByDataHoraAgendamentoBetween(inicio, fim);

        return lista.stream().map(this::toResponse).toList();
    }

    public AgendamentoResponse alterarAgendamento(AgendamentoRequest request, String cliente, LocalDateTime dataHoraAgendamento) {
        Agendamento agenda = agendamentoRepository.findByDataHoraAgendamentoAndCliente(dataHoraAgendamento, cliente);

        if (agenda == null) {
            throw new AgendamentoException("Horário não está preenchido");
        }

        Agendamento atualizado = toEntity(request);
        atualizado.setId(agenda.getId());

        Agendamento salvo = agendamentoRepository.save(atualizado);

        return toResponse(salvo);
    }

    private Agendamento toEntity(AgendamentoRequest request) {
        Agendamento agendamento = new Agendamento();
        agendamento.setServico(request.getServico());
        agendamento.setCliente(request.getCliente());
        agendamento.setProfissional(request.getProfissional());
        agendamento.setTelefone(request.getTelefone());
        agendamento.setDataHoraAgendamento(request.getDataHoraAgendamento());
        return agendamento;
    }

    private AgendamentoResponse toResponse(Agendamento agendamento) {
        return new AgendamentoResponse(agendamento.getId(), agendamento.getCliente(), agendamento.getDataHoraAgendamento(), agendamento.getServico(), agendamento.getProfissional(), agendamento.getTelefone());
    }
}
