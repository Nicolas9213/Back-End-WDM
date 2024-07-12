package com.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@RequiredArgsConstructor
@Entity
public class Dispositivo {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long numero;
    @ManyToOne
    @JoinColumn(nullable = false)
    private TipoDispositivo tipo;
    @Column(nullable = false, length = 50)
    private String marca;
    @Column(nullable = false, length = 50)
    private String modelo;
    @OneToMany(mappedBy = "dispositivo")
    private List<DispositivoReservado> reservasDoDispositivo;
    @OneToMany(mappedBy = "dispositivo")
    private List<Manutencao> manutencoes;
    private String descricao;
    private Boolean habilitado = true;
}
