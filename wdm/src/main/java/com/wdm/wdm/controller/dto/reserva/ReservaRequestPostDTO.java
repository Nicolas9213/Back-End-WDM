package com.wdm.wdm.controller.dto.reserva;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class ReservaRequestPostDTO {
    private Long idUsuario;
    private List<Long> idDispositivos;
    private Long idTurma;
    private List<PeriodoReservaRequestPostDTO> idPeriodos;
    private LocalDate inicio;
    private LocalDate fim;
}
