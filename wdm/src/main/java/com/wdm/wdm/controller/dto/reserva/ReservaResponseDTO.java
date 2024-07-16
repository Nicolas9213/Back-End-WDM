package com.wdm.wdm.controller.dto.reserva;

import com.wdm.wdm.entity.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

public record ReservaResponseDTO(
        Long numero,
        List<DispositivoReservado> dispositivoReservados,
        String status,
        Ambiente ambiente,
        Turma turma,
        Periodo periodo,
        LocalDate dia,
        String comentario) {
}
