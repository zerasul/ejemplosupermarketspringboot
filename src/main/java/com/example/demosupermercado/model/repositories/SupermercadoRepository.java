package com.example.demosupermercado.model.repositories;

import com.example.demosupermercado.model.entities.Supermercado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupermercadoRepository extends JpaRepository<Supermercado,Long> {
}
