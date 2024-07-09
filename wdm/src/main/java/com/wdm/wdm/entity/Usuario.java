package com.wdm.wdm.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
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
    @OneToMany(mappedBy = "solicitante")
    private List<Reserva> reservas;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipo;
    @OneToMany(mappedBy = "usuario")
    private List<GrupoDispositivo> gruposDispositivos;

    public Usuario(Long idUsuario) {
    }
}
