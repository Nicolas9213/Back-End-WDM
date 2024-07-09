package com.wdm.wdm.controller.dto.reserva;

import com.wdm.wdm.entity.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PeriodoReservaRequestPostDTO {
    private Long idPeriodo;
    private Long idAmbiente;
    private DiaSemana diaSemana;
}
