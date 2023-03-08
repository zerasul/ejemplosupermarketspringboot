package com.example.demosupermercado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "supermercado")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Supermercado {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @Column
    private List<Articulo> articulos;

    public void addArticulo(Articulo articulo){
        this.articulos.add(articulo);
        articulo.setSupermercado(this);
    }
}
