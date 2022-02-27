package com.example.barros_proyect.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "EVENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EVENTO")
    private Integer idEvento;

    @NonNull
    @Column(name = "FECHA")
    private Date fecha;

    @NonNull
    @Column(name = "HORA_INICIO")
    private Time horaInicio;


    @NonNull
    @Column(name = "HORA_FIN")
    private Time horaFin;

    @NonNull
    @Column(name = "COMIDA_CENA")
    private Boolean comidaCena;

    @NonNull
    @Column(name = "NUMERO_COMENSALES")
    private Integer numeroComensales;

    @NonNull
    @Column(name = "CONTRATO_ASOCIADO")
    private Integer contratoAsociado;

    @NonNull
    @Column(name = "MENU")
    private String menu;

    @NonNull
    @Column(name = "MENU_INFANTIL")
    private String menuInfantil;

    @Column(name = "MENU_ESPECIAL")
    private String menuEspecial;

    @NonNull
    @Column(name = "PLANOS")
    private String planos;

    @Column(name = "DJ")
    private String dj;

    @Column(name = "MUSICA_SALON")
    private String musicaSalon;

    @Column(name = "MUSICA_APERITIVO")
    private String musicaAperitivo;

    @Column(name = "MUSICA_BAILE")
    private String musicaBaile;

    @Column(name = "BARRA_LIBRE")
    private String barraLibre;

    @Column(name = "FLORES")
    private String flores;

    @Column(name = "CEREMONIA_BARROS")
    private Boolean ceremoniaBarros;

    @Column(name = "AUTOBUSES")
    private String autobuses;

    @Column(name = "BONO_AUTOBUS")
    private Boolean bonoAutobus;

    @Column(name = "BONO_HOTEL")
    private Boolean bonoHotel;

    @Column(name = "VINOS")
    private String vinos;

    @Column(name = "CAVA")
    private String cava;

    @Column(name = "RINCONES")
    private String rincones;

    @Column(name = "DECORACION")
    private String decoracion;

    @Column(name = "NOTAS")
    private String notas;

    @ManyToMany
    private List<Cliente> clientes;

    @ManyToMany
    private List<SubSalon> subsalones;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TIPO_EVENTO",nullable = false,updatable = false,insertable = false)
    private TipoEvento tipoEvento;



}
