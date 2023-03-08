package com.example.demosupermercado.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "articulo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Articulo {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nombre;

    @Column
    private Double precio;

    @Column
    private Boolean rebajado;

    @ManyToOne
    @JoinColumn(name = "supermercadoId")
    private Supermercado supermercado;
}
