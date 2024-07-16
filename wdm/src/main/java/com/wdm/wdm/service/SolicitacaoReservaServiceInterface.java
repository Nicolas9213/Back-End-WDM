package com.wdm.wdm.service;

import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import com.wdm.wdm.entity.SolicitacaoReserva;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SolicitacaoReservaServiceInterface {
    SolicitacaoReserva criarSolicitacaoReserva(SolicitacaoReservaRequestPostDTO reservaDto);
    SolicitacaoReserva buscarSolicitacao(Long id);
    List<SolicitacaoReservaResponseDTO> buscarTodasSolicitacoes();
    Page<SolicitacaoResponseDTO> buscarTodasSolicitacoesPage(Pageable pageable);
}
