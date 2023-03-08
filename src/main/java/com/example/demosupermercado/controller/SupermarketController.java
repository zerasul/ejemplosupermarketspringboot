package com.example.demosupermercado.controller;

import com.example.demosupermercado.model.entities.Articulo;
import com.example.demosupermercado.model.entities.Supermercado;
import com.example.demosupermercado.service.SupermercadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SupermarketController {

    private final SupermercadoService supermercadoService;

    @PostMapping("/articles")
    public Articulo saveArticle(@RequestBody Articulo articulo){
        return supermercadoService.saveArticle(articulo);
    }

    @GetMapping("/articles/{id}")
    public Articulo getArticulo(@PathVariable Long id){
        return supermercadoService.getArticle(id);
    }

    @GetMapping("/supermarket/{superMarketId}/articles")
    public List<Articulo> getArticlesFromMarket(@PathVariable Long superMarketId){
        return supermercadoService.getArticlesFromSuperMarket(superMarketId);
    }

    @PutMapping("/supermarket/{superMarketId}/articles")
    public List<Articulo> saveArticlesIntoSupermarket(@PathVariable Long superMarketId,@RequestBody List<Articulo> articulos){
        return supermercadoService.saverArticlesIntoSupermarket(superMarketId,articulos);
    }
}
