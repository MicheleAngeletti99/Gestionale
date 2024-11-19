package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.OggFarmacia;
import com.example.Gestionale.services.OggFarmaciaService;
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
@RequestMapping("/ogg-far")
@CrossOrigin(origins = {"http://localhost:3000"})
@Tag(name = "Oggetto Farmacia Controller", description = "Controller to manage the items of drug stores.")
public class OggFarmaciaController {
    // fields
    @Autowired
    private OggFarmaciaService oggFarmaciaService;

    // crud methods

    @Operation(summary = "Creates an item in ogg_farmacia.", description = "When given an OggFarmacia, creates a record with its data in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The given item has been added correctly in the database."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request.")
    })
    @PostMapping("/new/{idMagazzino}")
    public ResponseEntity<OggFarmacia> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The item that is going to be added in the database.") @RequestBody OggFarmacia oggetto,
            @Parameter(name = "idMagazzino", description = "The ID of the Magazzino to be retrieved or manipulated.")@PathVariable Long idMagazzino) {
        Optional<OggFarmacia> createdOgg = oggFarmaciaService.create(oggetto, idMagazzino);
        if (createdOgg.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOgg.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Reads all items in ogg_farmacia.", description = "Reads all the records in ogg_farmacia table in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The items were read correctly.")
    })
    @GetMapping("/all")
    public ResponseEntity<List<OggFarmacia>> readAll() {
        List<OggFarmacia> oggetti = oggFarmaciaService.readAll();
        return ResponseEntity.ok().body(oggetti);
    }

    @Operation(summary = "Reads an item in ogg_farmacia.", description = "When given an id, finds the item with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was found correctly."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @GetMapping("/read/{id}")
    public ResponseEntity<OggFarmacia> readById(@Parameter(name = "id", description = "The id of the item to be read.") @PathVariable Long id) {
        Optional<OggFarmacia> optionalOgg = oggFarmaciaService.readById(id);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Updates an item in ogg_farmacia.", description = "When given an id and an item with the new data, updates the item with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was updated correctly."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<OggFarmacia> update(
            @Parameter(name = "id", description = "The id of the item to be updated.") @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The item with the new data.") @RequestBody OggFarmacia oggetto) {
        Optional<OggFarmacia> optionalOgg = oggFarmaciaService.update(id, oggetto);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletes an item in ogg_farmacia.", description = "When given an id, deletes the item with that id from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The item was deleted correctly.")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@Parameter(name = "id", description = "The id of the item to be deleted") @PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    // other methods

    @Operation(summary = "Increases the amount of an item in ogg_farmacia.", description = "When given an id and a number," +
            " increases the amount of the item with that id in the database by the amount given by the number, decreases if the number is negative.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was updated correctly."),
            @ApiResponse(responseCode = "400", description = "The given number is not valid for this request."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @PutMapping("/{id}/restock/")
    public ResponseEntity<OggFarmacia> restock(
            @Parameter(name = "id", description = "The id of the item to be updated") @PathVariable Long id,
            @Parameter(name = "amount", description = "The amount of the increase, decrease if negative") @RequestParam(value = "num") Integer amount) {
        Optional<OggFarmacia> optionalOgg = oggFarmaciaService.restock(id, amount);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
