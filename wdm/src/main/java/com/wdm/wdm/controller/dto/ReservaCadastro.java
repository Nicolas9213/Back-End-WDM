package com.wdm.wdm.controller.dto;

import com.wdm.wdm.entity.DiaSemana;
import com.wdm.wdm.entity.Dispositivo;
import com.wdm.wdm.entity.Periodo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Data
public class ReservaCadastro {
    private Long idUsuario;
    private List<Long> idDispositivos;
    private Long idAmbiente;
    private Long idTurma;
    private List<PeriodoReservaCadastro> idPeriodos;
//    private List<DiaSemana> diasSemana;
    private LocalDate inicio;
    private LocalDate fim;
}
