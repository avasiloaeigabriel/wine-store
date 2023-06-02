package com.example.winestore.controller;

import com.example.winestore.dto.WineDTO;
import com.example.winestore.entity.Wine;
import com.example.winestore.service.WineService;
import com.example.winestore.service.impl.WineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WineController {
    private final WineService wineService;

    @Autowired
    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping
    public ResponseEntity<List<Wine>> getAllWines() {
        List<Wine> wines = wineService.getAllWines();
        return new ResponseEntity<>(wines, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Wine> getWineById(@PathVariable("id") Long id) {
        Wine wine = wineService.getWineById(id);
        if (wine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(wine, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Wine> createWine(@RequestBody WineDTO wineDTO) {
        Wine wine = new Wine();
        wine.setName(wineDTO.getName());
        wine.setAge(wineDTO.getAge());
        wine.setType(wineDTO.getType());

        Wine createdWine = wineService.createWine(wine);
        return new ResponseEntity<>(createdWine, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Wine> updateWine(
            @PathVariable("id") Long id,
            @RequestBody WineDTO wineDTO
    ) {
        Wine existingWine = wineService.getWineById(id);
        if (existingWine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        existingWine.setName(wineDTO.getName());
        existingWine.setAge(wineDTO.getAge());
        existingWine.setType(wineDTO.getType());

        Wine updatedWine = wineService.updateWine(id, existingWine);
        return new ResponseEntity<>(updatedWine, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWine(@PathVariable("id") Long id) {
        Wine existingWine = wineService.getWineById(id);
        if (existingWine == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        wineService.deleteWine(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}