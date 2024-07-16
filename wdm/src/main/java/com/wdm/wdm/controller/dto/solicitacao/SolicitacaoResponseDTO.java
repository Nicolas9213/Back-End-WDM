package com.wdm.wdm.controller.dto.solicitacao;

import com.wdm.wdm.controller.dto.periodo.PeriodoResponseDTO;
import com.wdm.wdm.entity.*;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoResponseDTO(
        Usuario solicitante,
        List<Dispositivo> dispositivos,
        Turma turma,
        List<PeriodoResponseDTO> periodos,
        LocalDate inicio,
        LocalDate fim
) {
}
