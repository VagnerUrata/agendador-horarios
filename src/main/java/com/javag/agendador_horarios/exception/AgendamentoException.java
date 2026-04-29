package com.javag.agendador_horarios.exception;

import com.javag.agendador_horarios.dto.AgendamentoResponse;

public class AgendamentoException extends RuntimeException {

    public AgendamentoException(String message) {
        super(message);
    }
}
