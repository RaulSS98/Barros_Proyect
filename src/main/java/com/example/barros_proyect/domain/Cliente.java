package com.example.barros_proyect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;

    @NonNull
    @Column(name = "NOMBRE")
    private String nombre;

    @NonNull
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;

    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;

    @NonNull
    @Column(name = "TELEFONO")
    private Integer telefono;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "OBSERVACIONES")
    private String observaciones;

    //@ManyToMany
    //private List<Evento> eventos;
}
