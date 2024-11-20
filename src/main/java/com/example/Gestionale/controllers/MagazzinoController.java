package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.services.MagazzinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/magazzino")
@CrossOrigin(origins = {"http://localhost:3000"})
@Tag(name = "Magazzino Controller", description = "Manages warehouse CRUD operations")
public class MagazzinoController {

    @Autowired
    private MagazzinoService magazzinoService;

    @Operation(summary = "Retrieve all warehouses", description = "Fetches a list of all Magazzino entries.")
    @ApiResponse(responseCode = "200", description = "List of warehouses retrieved successfully.")
    @GetMapping("/all")
    public ResponseEntity<List<Magazzino>> listaMagazzini(){
        System.out.println("Request successful");
        return ResponseEntity.ok(magazzinoService.readAll());
    }


    @Operation(summary = "Find a warehouse by ID", description = "Fetches a Magazzino by its ID if it exists.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Warehouse found."),
            @ApiResponse(responseCode = "404", description = "Warehouse not found.")
    })
    @GetMapping("/magazzino/{id}")
    public ResponseEntity<Magazzino> findById(@PathVariable Long id){
        Optional<Magazzino> optionalMagazzino = magazzinoService.readById(id);
        if (optionalMagazzino.isPresent()){
            return ResponseEntity.ok(optionalMagazzino.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new warehouse", description = "Creates a new Magazzino entry and returns it.")
    @ApiResponse(responseCode = "201", description = "Warehouse created successfully.")
    @PostMapping("/create/{idUtente}")
    public ResponseEntity<Magazzino> create(@RequestBody Magazzino magazzino, @PathVariable Long idUtente){
        Optional<Magazzino> optionalMagazzino = magazzinoService.create(idUtente, magazzino);
        if (optionalMagazzino.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(optionalMagazzino.get());
        }
        return ResponseEntity.notFound().build();
    }


    @Operation(summary = "Update a warehouse by ID", description = "Updates an existing Magazzino by its ID.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Warehouse updated successfully."),
            @ApiResponse(responseCode = "404", description = "Warehouse not found.")
    })
    @PutMapping("/modify/{id}")
    public ResponseEntity<Magazzino> update(@PathVariable Long id, @RequestBody Magazzino magazzino){
        Optional<Magazzino> optionalMagazzino = magazzinoService.update(id, magazzino);
        if (optionalMagazzino.isPresent()){
            return ResponseEntity.ok(optionalMagazzino.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Delete a warehouse by ID", description = "Deletes a Magazzino by its ID and removes all related objects")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Warehouse deleted successfully."),
            @ApiResponse(responseCode = "404", description = "Warehouse not found.")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        boolean deleteMagazzino = magazzinoService.delete(id);
        if (deleteMagazzino){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
