package com.wdm.wdm.controller.dto.solicitacao;

import com.wdm.wdm.controller.dto.periodo.PeriodoReservaRequestPostDTO;

import java.time.LocalDate;
import java.util.List;

public record SolicitacaoReservaRequestPostDTO(
         Long idUsuario,
         List<Long>idDispositivos,
         Long idTurma,
         List<PeriodoReservaRequestPostDTO> periodos,
         LocalDate inicio,
         LocalDate fim) {
}
