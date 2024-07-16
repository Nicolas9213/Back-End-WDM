package com.wdm.wdm.controller.dto.periodo;

import com.wdm.wdm.entity.DiaSemana;

public record PeriodoReservaRequestPostDTO(
         Long idPeriodo,
         Long idAmbiente,
         DiaSemana diaSemana) {

}
