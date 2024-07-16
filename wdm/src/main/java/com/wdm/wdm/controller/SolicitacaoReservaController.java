package com.wdm.wdm.controller;

import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaRequestPostDTO;
import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoReservaResponseDTO;
import com.wdm.wdm.controller.dto.solicitacao.SolicitacaoResponseDTO;
import com.wdm.wdm.entity.SolicitacaoReserva;
import com.wdm.wdm.service.SolicitacaoReservaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/solicitacao")
public class SolicitacaoReservaController {

    private SolicitacaoReservaServiceImpl solicitacaoReservaService;

    @PostMapping
    public ResponseEntity<SolicitacaoReserva> cadastroSolicitacao(
            @RequestBody SolicitacaoReservaRequestPostDTO reservaDTO) {
        solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO);
        return ResponseEntity.ok(solicitacaoReservaService.criarSolicitacaoReserva(reservaDTO));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SolicitacaoReserva> buscarSolicitacao(@PathVariable Long id) {
        return new ResponseEntity<>(solicitacaoReservaService.buscarSolicitacao(id),
                HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<SolicitacaoReservaResponseDTO>> buscarTodasSolicitacoes() {
        return new ResponseEntity<>(
                solicitacaoReservaService.buscarTodasSolicitacoes(), HttpStatus.OK);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<SolicitacaoResponseDTO>> buscarTodasSolicitacoesPage(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 5)
            Pageable pageable) {
        return new ResponseEntity<>(
                solicitacaoReservaService.buscarTodasSolicitacoesPage(pageable), HttpStatus.OK);
    }
}