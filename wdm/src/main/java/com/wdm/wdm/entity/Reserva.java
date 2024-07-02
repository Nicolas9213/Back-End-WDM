package com.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @ManyToOne
    @Column(nullable = false)
    private Usuario solicitante;
    @OneToMany(mappedBy = "reserva",cascade = CascadeType.ALL)
    private List<DispositivoReservado> dispositivoReservados;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusReserva status;
    @ManyToOne
    private Ambiente ambiente;
    @ManyToOne
    private Turma turma;
    @ManyToOne
    @Column(nullable = false)
    private Periodo periodo;
    @Column(nullable = false)
    private LocalDate dia;
    @ManyToOne
    @Column(nullable = false)
    private SolicitacaoReserva solicitacaoReserva;
    private String comentario;
}
