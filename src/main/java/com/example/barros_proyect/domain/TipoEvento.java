package com.example.barros_proyect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TIPO_EVENTO")
public class TipoEvento {

    @Id
    @GeneratedValue
    @Column(name = "ID_TIPO_EVENTO")
    private Integer idTipoEvento;

    @NonNull
    @Column(name = "NOMBRE_EVENTO")
    private String nombreEvento;

    @OneToMany(mappedBy ="tipoEvento" ,cascade = CascadeType.ALL)
    private List<Evento> eventos = new ArrayList<>();
}
