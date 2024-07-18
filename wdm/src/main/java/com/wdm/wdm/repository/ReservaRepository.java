package com.wdm.wdm.repository;

import com.wdm.wdm.entity.Reserva;
import com.wdm.wdm.entity.StatusReserva;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    Page<Reserva> findAllByTurma_IdAndStatusOrderByDiaDesc(Long idTurma, StatusReserva statusReserva);
}
