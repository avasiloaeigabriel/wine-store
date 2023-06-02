package com.example.winestore.service.impl;

import com.example.winestore.entity.Wine;
import com.example.winestore.repository.WineRepository;
import com.example.winestore.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;

    @Autowired
    public WineServiceImpl(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @Override
    public List<Wine> getAllWines() {
        return wineRepository.findAll();
    }

    @Override
    public Wine getWineById(Long id) {
        Optional<Wine> optionalWine = wineRepository.findById(id);
        return optionalWine.orElse(null);
    }

    @Override
    public Wine createWine(Wine wine) {
        return wineRepository.save(wine);
    }

    @Override
    public Wine updateWine(Long id, Wine wine) {
        Wine existingWine = getWineById(id);
        if (existingWine == null) {
            return null;
        }
        wine.setId(existingWine.getId());
        return wineRepository.save(wine);
    }

    @Override
    public void deleteWine(Long id) {
        wineRepository.deleteById(id);
    }
}
