package com.example.TPIAlberdiTomas.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public final class Odontologo {

    @Id
    @Column(name = "id", nullable = false)
    private Integer matricula;

    private String apellido;
    private String nombre;
}   