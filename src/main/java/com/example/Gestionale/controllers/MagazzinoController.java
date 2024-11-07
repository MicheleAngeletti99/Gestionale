package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.services.MagazzinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/magazzino")
public class MagazzinoController {

    @Autowired
    private MagazzinoService magazzinoService;

    @GetMapping("/all")
    public ResponseEntity<List<Magazzino>> listaMagazzini(){
        return ResponseEntity.ok(magazzinoService.readAll());
    }

    @GetMapping("/magazzino/{id}")
    public ResponseEntity<Magazzino> findById(@PathVariable Long id){
        Optional<Magazzino> optionalMagazzino = magazzinoService.readById(id);
        if (optionalMagazzino.isPresent()){
            return ResponseEntity.ok(optionalMagazzino.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<Magazzino> newMagazzino(@RequestBody Magazzino magazzino){
        Magazzino nuovoMagazzino = magazzinoService.create(magazzino);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuovoMagazzino);
    }

    @PutMapping("/modify/{id}")
    public ResponseEntity<Magazzino> update(@PathVariable Long id, @RequestBody Magazzino magazzino){
        Optional<Magazzino> optionalMagazzino = magazzinoService.update(id, magazzino);
        if (optionalMagazzino.isPresent()){
            return ResponseEntity.ok(optionalMagazzino.get());
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deleteMagazzino = magazzinoService.delete(id);
        if (deleteMagazzino){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
