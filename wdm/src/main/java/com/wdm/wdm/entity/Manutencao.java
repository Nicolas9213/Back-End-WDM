package com.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ietf.jgss.GSSName;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    @ManyToOne
    @Column(nullable = false)
    private Usuario solicitante;
    @Column(nullable = false)
    private Dispositivo dispositivo;
    @Column(nullable = false)
    private String descricao;
    private String feedback;
    @Column(nullable = false)
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusManutencao status;
}
