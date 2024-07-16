package com.wdm.wdm.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class DispositivoReservado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    @ManyToOne
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Dispositivo dispositivo;
    private LocalDateTime retirada;
    private LocalDateTime devolucao;
//    @ManyToOne
//    @JoinColumn(nullable = false)
//    @NonNull
//    @ToString.Exclude
//    @JsonIgnore
//    private Reserva reserva;
}
