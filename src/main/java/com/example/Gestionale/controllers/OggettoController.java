package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.Oggetto;
import com.example.Gestionale.services.OggettoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ogg")
@CrossOrigin(origins = {"http://localhost:3000"})
public class OggettoController {
    @Autowired
    private OggettoService oggettoService;

    @PostMapping("/new")
    public ResponseEntity<Oggetto> create(@RequestBody Oggetto oggetto){
        Oggetto savedOggetto = oggettoService.create(oggetto);
        return ResponseEntity.ok().body(savedOggetto);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Oggetto>> readAll() {
        List<Oggetto> oggetti = oggettoService.readAll();
        return ResponseEntity.ok().body(oggetti);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Oggetto> update(@PathVariable Long id, @RequestBody Oggetto oggetto) {
        Optional<Oggetto> optionalOggetto = oggettoService.update(id, oggetto);
        if (optionalOggetto.isPresent()) {
            return ResponseEntity.ok().body(optionalOggetto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return ResponseEntity.ok().build();
    }
}
