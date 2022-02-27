package com.example.barros_proyect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "SALON")
public class Salon {

    @Id
    @GeneratedValue
    @Column(name = "ID_SALON")
    private Integer idSalon;

    @NonNull
    @Column(name = "NOMBRE_SALON")
    private String nombreSalon;

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL)
    private List<SubSalon> subSalonByIdSalon = new ArrayList<>();
}
