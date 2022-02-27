package com.example.barros_proyect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue
    @Column(name = "ID_USUARIO")
    private Integer idUsuario;

    @NonNull
    @Column(name = "NOMBRE_USUARIO")
    private String nombreUsuario;

    @NonNull
    @Column(name = "CONTRASENIA")
    private String contrasenia;
}
