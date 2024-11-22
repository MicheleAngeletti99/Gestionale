package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.Magazzino;
import com.example.Gestionale.services.MagazzinoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

    // search methods

    @Operation(summary = "Searches warehouses by fields.", description = "When given fields of a Magazzino, searches all the warehouses " +
            "that have fields similar to the ones given.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Warehouses found successfully."),
            @ApiResponse(responseCode = "204", description = "No warehouses found."),
            @ApiResponse(responseCode = "400", description = "The given Magazzino is not valid for this request.")
    })
    @GetMapping("/search")
    public ResponseEntity<List<Magazzino>> findByFields(
            @Parameter(name = "nome", description = "A String contained in the name to be searched") @RequestParam(value = "nome", required = false) String nomeAttivita,
            @Parameter(name = "indirizzo", description = "A String contained in the address to be searched") @RequestParam(value = "indirizzo", required = false) String indirizzo,
            @Parameter(name = "tipo", description = "The exact type to be searched") @RequestParam(value = "tipo", required = false) String tipologiaAttivita
    ) {
        List<Magazzino> magazzini = magazzinoService.findByFields(nomeAttivita, indirizzo, tipologiaAttivita);
        if (magazzini.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(magazzini);
    }
}
