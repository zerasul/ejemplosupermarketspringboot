package com.example.demosupermercado.model.repositories;

import com.example.demosupermercado.model.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticuloRepository extends JpaRepository<Articulo,Long> {

    List<Articulo> findByRebajado(Boolean rebajado);
}
