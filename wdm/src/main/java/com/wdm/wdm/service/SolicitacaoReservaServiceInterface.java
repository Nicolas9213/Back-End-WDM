package com.wdm.wdm.service;

import com.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import com.wdm.wdm.entity.SolicitacaoReserva;
import org.springframework.stereotype.Service;

@Service
public interface SolicitacaoReservaServiceInterface {
    SolicitacaoReserva criarSolicitacaoReserva(ReservaRequestPostDTO reservaDto);
}
