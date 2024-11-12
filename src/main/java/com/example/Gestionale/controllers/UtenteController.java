package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.Utente;
import com.example.Gestionale.services.UtenteService;
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
@RequestMapping("/user")
@CrossOrigin(origins = {"http://localhost:3000"})
@Tag(name = "Utente Controller", description = "Controller to manage the users.")
public class UtenteController {
    // fields
    @Autowired
    private UtenteService utenteService;

    // crud methods

    @Operation(summary = "Creates a user in utenti.", description = "When given an Utente, creates a record with its data in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The given user has been added correctly in the database."),
            @ApiResponse(responseCode = "400", description = "The given user is not valid for this request.")
    })
    @PostMapping("/new")
    public ResponseEntity<Utente> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The user that is going to be added in the database.") @RequestBody Utente utente) {
        Utente createdUtente = utenteService.create(utente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUtente);
    }

    @Operation(summary = "Reads all users in utenti.", description = "Reads all the records in utenti table in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The users were read correctly.")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Utente>> readAll() {
        List<Utente> utenti = utenteService.readAll();
        return ResponseEntity.ok().body(utenti);
    }

    @Operation(summary = "Reads a user in utenti.", description = "When given an id, finds the user with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user was found correctly."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @GetMapping("/read/{id}")
    public ResponseEntity<Utente> readById(@Parameter(name = "id", description = "The id of the user to be read.") @PathVariable Long id) {
        Optional<Utente> optionalUtente = utenteService.readById(id);
        if (optionalUtente.isPresent()) {
            return ResponseEntity.ok().body(optionalUtente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Updates a user in utenti.", description = "When given an id and a user with the new data, updates the user with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The user was updated correctly."),
            @ApiResponse(responseCode = "400", description = "The given user is not valid for this request."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<Utente> update(
            @Parameter(name = "id", description = "The id of the user to be updated.") @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The user with the new data.") @RequestBody Utente utente) {
        Optional<Utente> optionalUtente = utenteService.update(id, utente);
        if (optionalUtente.isPresent()) {
            return ResponseEntity.ok().body(optionalUtente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletes a user in utenti.", description = "When given an id, deletes the user with that id from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The user was deleted correctly.")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
