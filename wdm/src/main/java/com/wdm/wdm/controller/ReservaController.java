package com.wdm.wdm.controller;

import com.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import com.wdm.wdm.entity.SolicitacaoReserva;
import com.wdm.wdm.service.ReservaServiceInterface;
import com.wdm.wdm.service.SolicitacaoReservaServiceImpl;
import com.wdm.wdm.service.SolicitacaoReservaServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    private SolicitacaoReservaServiceImpl solicitacaoReservaServiceImpl;

    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroReserva(
            @RequestBody ReservaRequestPostDTO reservaDTO) {
        solicitacaoReservaServiceImpl.criarSolicitacaoReserva(reservaDTO);
        return ResponseEntity.ok(solicitacaoReservaServiceImpl.criarSolicitacaoReserva(reservaDTO));
    }
}