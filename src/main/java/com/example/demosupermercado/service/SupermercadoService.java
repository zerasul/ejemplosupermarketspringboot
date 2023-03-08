package com.example.demosupermercado.service;

import com.example.demosupermercado.model.entities.Articulo;
import com.example.demosupermercado.model.entities.Supermercado;

import java.util.List;

public interface SupermercadoService {

    Articulo saveArticle(Articulo articulo);
    Articulo addArticleToSupermarket(Long supermercadoId, Long articuloId);

    List<Articulo> getArticlesFromSuperMarket(Long superMercadoId);

    Articulo getArticle(Long articleId);

    List<Articulo> saverArticlesIntoSupermarket(Long superMarketId,List<Articulo> articles);
}
