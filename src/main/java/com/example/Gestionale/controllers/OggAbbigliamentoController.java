package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.OggAbbigliamento;
import com.example.Gestionale.services.OggAbbigliamentoService;
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
@RequestMapping("/ogg-abb")
@CrossOrigin(origins = {"http://localhost:3000"})
@Tag(name = "Oggetto Abbigliamento Controller", description = "Controller to manage the items of clothing shops.")
public class OggAbbigliamentoController {
    // fields
    @Autowired
    private OggAbbigliamentoService oggAbbigliamentoService;

    // crud methods

    @Operation(summary = "Creates an item in ogg_abbigliamento.", description = "When given an OggAbbigliamento, creates a record with its data in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The given item has been added correctly in the database."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request.")
    })
    @PostMapping("/new")
    public ResponseEntity<OggAbbigliamento> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The item that is going to be added in the database.") @RequestBody OggAbbigliamento oggetto) {
        OggAbbigliamento createdOgg = oggAbbigliamentoService.create(oggetto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOgg);
    }

    @Operation(summary = "Reads all items in ogg_abbigliamento.", description = "Reads all the records in ogg_abbigliamento table in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The items were read correctly.")
    })
    @GetMapping("/all")
    public ResponseEntity<List<OggAbbigliamento>> readAll() {
        List<OggAbbigliamento> oggetti = oggAbbigliamentoService.readAll();
        return ResponseEntity.ok().body(oggetti);
    }

    @Operation(summary = "Reads an item in ogg_abbigliamento.", description = "When given an id, finds the item with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was found correctly."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @GetMapping("/read/{id}")
    public ResponseEntity<OggAbbigliamento> readById(@Parameter(name = "id", description = "The id of the item to be read.") @PathVariable Long id) {
        Optional<OggAbbigliamento> optionalOgg = oggAbbigliamentoService.readById(id);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Updates an item in ogg_abbigliamento.", description = "When given an id and an item with the new data, updates the item with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was updated correctly."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<OggAbbigliamento> update(
            @Parameter(name = "id", description = "The id of the item to be updated.") @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The item with the new data.") @RequestBody OggAbbigliamento oggetto) {
        Optional<OggAbbigliamento> optionalOgg = oggAbbigliamentoService.update(id, oggetto);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletes an item in ogg_abbigliamento.", description = "When given an id, deletes the item with that id from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The item was deleted correctly.")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
