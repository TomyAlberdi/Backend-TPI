package com.example.TPIAlberdiTomas.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public final class Paciente {
    @Id
    @Column(name = "dni", nullable = false)
    private Integer dni;

    private String apellido;
    private String nombre;
    private String domicilio;
    private LocalDate fecha_alta;
}