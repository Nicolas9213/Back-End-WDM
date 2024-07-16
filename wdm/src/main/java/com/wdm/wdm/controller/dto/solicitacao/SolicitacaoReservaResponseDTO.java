package com.wdm.wdm.controller.dto.solicitacao;

import com.wdm.wdm.controller.dto.reserva.ReservaResponseDTO;

import java.util.List;

public record SolicitacaoReservaResponseDTO(
        Long id,
        List<ReservaResponseDTO> reservas) {
}
