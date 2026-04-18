package br.com.musicist.infra.advice;

import java.time.LocalDateTime;

import br.com.musicist.common.enums.InstrumentType;
import br.com.musicist.common.enums.LevelType;

public record ApiErrorResponse(
    int status,
    String message,
    String path,
    LocalDateTime timestamp
) {
    
}