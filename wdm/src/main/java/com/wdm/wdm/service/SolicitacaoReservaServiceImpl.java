package com.wdm.wdm.service;

import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import com.wdm.wdm.entity.*;
import com.wdm.wdm.repository.SolicitacaoReservaRepository;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInterface{

    private final DispositivoServiceImpl dispositivoService;
    private final SolicitacaoReservaRepository repository;

    @Override
    public SolicitacaoReserva criarSolicitacaoReserva(SolicitacaoReservaRequestPostDTO reservaDTO) {
        Map<TipoDispositivo, List<Dispositivo>> dispositivos = dispositivoService.
                buscarDispositivosPorIdSeparadosPorTipo(reservaDTO.idDispositivos());

        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva(reservaDTO, dispositivos);
        return repository.save(solicitacaoReserva);
    }
    @Override
    public SolicitacaoReserva buscarSolicitacao(Long id) {
        return repository.findById(id).get();
    }
    @Override
    public List<SolicitacaoReservaResponseDTO> buscarTodasSolicitacoes() {
        List<SolicitacaoReserva> solicitacoes = repository.findAll();
        List<SolicitacaoReservaResponseDTO> response =
                solicitacoes.stream().map(SolicitacaoReserva::toDto).toList();
        return response;
    }
    @Override
    public Page<SolicitacaoResponseDTO> buscarTodasSolicitacoesPage(Pageable pageable) {
        Page<SolicitacaoReserva> solicitacoes = repository.findAll(pageable);
        Page<SolicitacaoResponseDTO> response;
        return solicitacoes.map(solicitacao -> solicitacao.toOtherDTO());
    }
}