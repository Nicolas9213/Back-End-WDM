package com.wdm.wdm.service;

import com.wdm.wdm.controller.dto.reserva.PeriodoReservaRequestPostDTO;
import com.wdm.wdm.controller.dto.reserva.ReservaRequestPostDTO;
import com.wdm.wdm.entity.*;
import com.wdm.wdm.repository.SolicitacaoReservaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class SolicitacaoReservaServiceImpl implements SolicitacaoReservaServiceInterface{


    private final UsuarioServiceImpl usuarioService;
    private final DispositivoServiceImpl dispositivoService;
    private final SolicitacaoReservaRepository repository;

    @Override
    public SolicitacaoReserva criarSolicitacaoReserva(
        ReservaRequestPostDTO reservaDTO) {
        SolicitacaoReserva solicitacaoReserva = new SolicitacaoReserva();
        Map<TipoDispositivo, List<Dispositivo>> dispositivos = dispositivoService.
                buscarDispositivosPorIdSeparadosPorTipo(
                reservaDTO.getIdDispositivos());

        Set<TipoDispositivo> tipos = dispositivos.keySet();

        List<Reserva> reservas = new ArrayList<>();
        LocalDate data = reservaDTO.getInicio();


        do {
            for (PeriodoReservaRequestPostDTO periodoDTO : reservaDTO.getIdPeriodos()) {
                DayOfWeek diaDaSemana = data.getDayOfWeek();
                if (periodoDTO.getDiaSemana().ordinal() == diaDaSemana.ordinal()) {
                    for (TipoDispositivo tipo : tipos) {
                        Reserva reserva = criarReserva(reservaDTO, periodoDTO,
                                data, dispositivos.get(tipo));
                        reservas.add(reserva);
                    }
                }
            }
                data = data.plusDays(1);
            } while (data.isBefore(reservaDTO.getFim().plusDays(1)));
            System.out.println(solicitacaoReserva);
            repository.save(solicitacaoReserva);
            System.out.println(solicitacaoReserva);
            solicitacaoReserva.setReservas(reservas);
            System.out.println(solicitacaoReserva);
            return repository.save(solicitacaoReserva);
        }

    private Reserva criarReserva(ReservaRequestPostDTO reservaDTO,
                                 PeriodoReservaRequestPostDTO periodoDTO, LocalDate data,
                                 List<Dispositivo> dispositivos) {
        Reserva reserva = new Reserva();
        reserva.setSolicitante(new Usuario(reservaDTO.getIdUsuario()));
        reserva.setDia(data);
        reserva.setPeriodo(new Periodo(periodoDTO.getIdPeriodo()));
        reserva.setAmbiente(new Ambiente(periodoDTO.getIdAmbiente()));
        reserva.setTurma(new Turma(reservaDTO.getIdTurma()));
        reserva.setDispositivoReservados(
                dispositivos.stream().map(
                        DispositivoReservado :: new).toList());
        return reserva;
    }
}
