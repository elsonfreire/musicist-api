package br.com.musicist.modules.repertoire.dto;

import br.com.musicist.modules.repertoire.enums.LearningStatusType;
import jakarta.validation.constraints.NotNull;

public record UpdateStatusSongRequest(
    @NotNull(message = "Status is required") LearningStatusType status) {}
