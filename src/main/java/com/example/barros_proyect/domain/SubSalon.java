package com.example.barros_proyect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SUB_SALON")
public class SubSalon {

    @Id
    @GeneratedValue
    @Column(name = "ID_SUBSALON")
    private Integer idSubSalon;

    @NonNull
    @Column(name = "NOMBRE_SUBSALON")
    private String nombreSubsalon;

    //@ManyToMany
    //List<Evento> eventos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SALON",nullable = false,updatable = false,insertable = false)
    private Salon salon;

}
