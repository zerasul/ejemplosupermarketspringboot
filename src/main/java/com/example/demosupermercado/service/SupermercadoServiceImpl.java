package com.example.demosupermercado.service;

import com.example.demosupermercado.model.entities.Articulo;
import com.example.demosupermercado.model.entities.Supermercado;
import com.example.demosupermercado.model.repositories.ArticuloRepository;
import com.example.demosupermercado.model.repositories.SupermercadoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SupermercadoServiceImpl implements SupermercadoService {

    private final ArticuloRepository articuloRepository;

    private final SupermercadoRepository supermercadoRepository;

    @Override
    public Articulo saveArticle(Articulo articulo) {
        return articuloRepository.save(articulo);
    }

    @Override
    public Articulo addArticleToSupermarket(Long supermercadoId, Long articuloId) {
        Supermercado supermercado = supermercadoRepository.findById(supermercadoId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

        Articulo articulo = articuloRepository.findById(articuloId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        supermercado.addArticulo(articulo);
        return articulo;
    }

    @Override
    public List<Articulo> getArticlesFromSuperMarket(Long superMercadoId) {
        Supermercado supermercado = supermercadoRepository.findById(superMercadoId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        return supermercado.getArticulos();
    }

    @Override
    public Articulo getArticle(Long articleId) {
        return articuloRepository.findById(articleId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Articulo> saverArticlesIntoSupermarket(Long superMarketId, List<Articulo> articles) {
        Supermercado supermercado = supermercadoRepository.findById(superMarketId)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
        articles = articles.stream().map(this::saveArticle).collect(Collectors.toList());
        articles.forEach(articulo -> addArticleToSupermarket(supermercado.getId(),articulo.getId()));
        return articles;
    }
}
