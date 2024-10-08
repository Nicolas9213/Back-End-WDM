package com.wdm.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@Entity
@RequiredArgsConstructor
public class Usuario {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String nome;
    @Column(nullable = false, unique = true, length = 200)
    private String email;
    @Column(nullable = false)
    private String senha;
    private Boolean habilitado;
//    @OneToMany()
//    @JoinColumn(name = "id_solicitante")
//    private List<SolicitacaoReserva> reservas;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;
    @OneToMany(mappedBy = "usuario")
    private List<GrupoDispositivo> gruposDispositivos;
}
