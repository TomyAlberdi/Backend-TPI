package com.example.TPIAlberdiTomas.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SuppressWarnings("ALL")
@Entity
@Getter
@Setter
public final class Turno {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_odontologo")
    private Odontologo odontologo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dni_paciente")
    private Paciente paciente;

    private LocalDateTime fecha;
}