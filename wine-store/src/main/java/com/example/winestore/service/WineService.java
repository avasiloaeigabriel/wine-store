package com.example.winestore.service;

import com.example.winestore.entity.Wine;

import java.util.List;

public interface WineService {
    List<Wine> getAllWines();

    Wine getWineById(Long id);

    Wine createWine(Wine wine);

    Wine updateWine(Long id, Wine wine);

    void deleteWine(Long id);
}
