package com.example.Gestionale.controllers;

import com.example.Gestionale.entities.OggPub;
import com.example.Gestionale.services.OggPubService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ogg-pub")
@CrossOrigin(origins = {"http://localhost:3000"})
@Tag(name = "Oggetto Pub Controller", description = "Controller to manage the items of pubs.")
public class OggPubController {
    // fields
    @Autowired
    private OggPubService oggPubService;

    // crud methods

    @Operation(summary = "Creates an item in ogg_pub.", description = "When given an OggPub, creates a record with its data in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "The given item has been added correctly in the database."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request.")
    })
    @PostMapping("/new/{idMagazzino}")
    public ResponseEntity<OggPub> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The item that is going to be added in the database.") @RequestBody OggPub oggetto,
            @Parameter(name = "idMagazzino", description = "The ID of the Magazzino to be retrieved or manipulated.")@PathVariable Long idMagazzino) {
        Optional<OggPub> createdOgg = oggPubService.create(oggetto, idMagazzino);
        if (createdOgg.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOgg.get());
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Reads all items in ogg_pub.", description = "Reads all the records in ogg_pub table in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The items were read correctly.")
    })
    @GetMapping("/all")
    public ResponseEntity<List<OggPub>> readAll() {
        List<OggPub> oggetti = oggPubService.readAll();
        return ResponseEntity.ok().body(oggetti);
    }

    @Operation(summary = "Reads an item in ogg_pub.", description = "When given an id, finds the item with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was found correctly."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @GetMapping("/read/{id}")
    public ResponseEntity<OggPub> readById(@Parameter(name = "id", description = "The id of the item to be read.") @PathVariable Long id) {
        Optional<OggPub> optionalOgg = oggPubService.readById(id);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Updates an item in ogg_pub.", description = "When given an id and an item with the new data, updates the item with that id in the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was updated correctly."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @PutMapping("/update/{id}")
    public ResponseEntity<OggPub> update(
            @Parameter(name = "id", description = "The id of the item to be updated.") @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The item with the new data.") @RequestBody OggPub oggetto) {
        Optional<OggPub> optionalOgg = oggPubService.update(id, oggetto);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletes an item in ogg_pub.", description = "When given an id, deletes the item with that id from the database.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "The item was deleted correctly.")
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@Parameter(name = "id", description = "The id of the item to be deleted") @PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    // search methods

    @Operation(summary = "Searches items by fields.", description = "When given fields of an OggPub, searches all the items " +
            "that have fields similar to the ones given.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Items found successfully."),
            @ApiResponse(responseCode = "204", description = "No items found."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request.")
    })
    @GetMapping("/search")
    public ResponseEntity<List<OggPub>> findByFields(
            @Parameter(name = "nome", description = "A String contained in the name to be searched") @RequestParam(value = "nome", required = false) String nome,
            @Parameter(name = "prezzo", description = "The max price to be searched") @RequestParam(value = "prezzo", required = false) Double prezzo,
            @Parameter(name = "quantita", description = "The min number of items in stock") @RequestParam(value = "quantita", required = false) Integer quantita,
            @Parameter(name = "descrizione", description = "A String contained in the description to be searched") @RequestParam(value = "descrizione", required = false) String descrizione,
            @Parameter(name = "scadenza", description = "The earliest expiring date to be searched") @RequestParam(value = "scadenza", required = false) LocalDate scadenza,
            @Parameter(name = "tipo", description = "The exact type to be searched") @RequestParam(value = "tipo", required = false) String tipologia
    ) {
        List<OggPub> items = oggPubService.findByFields(nome, prezzo, quantita, descrizione, scadenza, tipologia);
        if (items.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(items);
    }

    // other methods

    @Operation(summary = "Increases the amount of an item in ogg_pub.", description = "When given an id and a number," +
            " increases the amount of the item with that id in the database by the amount given by the number, decreases if the number is negative.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was updated correctly."),
            @ApiResponse(responseCode = "400", description = "The given number is not valid for this request."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @PutMapping("/{id}/restock/")
    public ResponseEntity<OggPub> restock(
            @Parameter(name = "id", description = "The id of the item to be updated") @PathVariable Long id,
            @Parameter(name = "amount", description = "The amount of the increase, decrease if negative") @RequestParam(value = "num") Integer amount) {
        Optional<OggPub> optionalOgg = oggPubService.restock(id, amount);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
