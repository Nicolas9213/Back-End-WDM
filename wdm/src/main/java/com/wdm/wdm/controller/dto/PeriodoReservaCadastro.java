package com.wdm.wdm.controller.dto;

import com.wdm.wdm.entity.DiaSemana;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PeriodoReservaCadastro {
    private Long idTurma;
    private Long idPeriodo;
    private Long idAmbiente;
    private DiaSemana diaSemana;
}
