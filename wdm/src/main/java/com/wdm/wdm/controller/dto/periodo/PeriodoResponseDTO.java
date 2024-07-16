package com.wdm.wdm.controller.dto.periodo;

import com.wdm.wdm.entity.Ambiente;
import com.wdm.wdm.entity.DiaSemana;
import com.wdm.wdm.entity.Periodo;

public record PeriodoResponseDTO(
        Periodo periodo,
        Ambiente ambiente,
        String diaSemana) {
}
