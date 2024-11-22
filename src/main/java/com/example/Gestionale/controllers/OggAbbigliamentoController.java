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
    @PostMapping("/new/{idMagazzino}")
    public ResponseEntity<OggAbbigliamento> create(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "The item that is going to be added in the database.") @RequestBody OggAbbigliamento oggetto,
            @Parameter(name = "idMagazzino", description = "The ID of the Magazzino to be retrieved or manipulated.")@PathVariable Long idMagazzino) {
        Optional<OggAbbigliamento> createdOgg = oggAbbigliamentoService.create(oggetto, idMagazzino);
        if (createdOgg.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(createdOgg.get());
        }
        return ResponseEntity.notFound().build();
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
    public ResponseEntity<Void> deleteById(@Parameter(name = "id", description = "The id of the item to be deleted") @PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

    // search methods

    @Operation(summary = "Searches items by fields.", description = "When given fields of an OggAbbigliamento, searches all the items " +
            "that have fields similar to the ones given.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Items found successfully."),
            @ApiResponse(responseCode = "204", description = "No items found."),
            @ApiResponse(responseCode = "400", description = "The given item is not valid for this request.")
    })
    @GetMapping("/search")
    public ResponseEntity<List<OggAbbigliamento>> findByFields(
            @Parameter(name = "nome", description = "A String contained in the name to be searched") @RequestParam(value = "nome", required = false) String nome,
            @Parameter(name = "prezzo", description = "The max price to be searched") @RequestParam(value = "prezzo", required = false) Double prezzo,
            @Parameter(name = "quantita", description = "The min number of items in stock") @RequestParam(value = "quantita", required = false) Integer quantita,
            @Parameter(name = "descrizione", description = "A String contained in the description to be searched") @RequestParam(value = "descrizione", required = false) String descrizione,
            @Parameter(name = "marca", description = "A String contained in the brand to be searched") @RequestParam(value = "marca", required = false) String marca,
            @Parameter(name = "taglia", description = "The exact size to be searched") @RequestParam(value = "taglia", required = false) String taglia,
            @Parameter(name = "tipo", description = "The exact type to be searched") @RequestParam(value = "tipo", required = false) String tipologia
    ) {
        List<OggAbbigliamento> items = oggAbbigliamentoService.findByFields(nome, prezzo, quantita, descrizione, marca, taglia, tipologia);
        if (items.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok().body(items);
    }

    // other methods

    @Operation(summary = "Increases the amount of an item in ogg_abbigliamento.", description = "When given an id and a number," +
            " increases the amount of the item with that id in the database by the amount given by the number, decreases if the number is negative.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The item was updated correctly."),
            @ApiResponse(responseCode = "400", description = "The given number is not valid for this request."),
            @ApiResponse(responseCode = "404", description = "The id was not found in the database.")
    })
    @PutMapping("/{id}/restock/")
    public ResponseEntity<OggAbbigliamento> restock(
            @Parameter(name = "id", description = "The id of the item to be updated") @PathVariable Long id,
            @Parameter(name = "amount", description = "The amount of the increase, decrease if negative") @RequestParam(value = "num") Integer amount) {
        Optional<OggAbbigliamento> optionalOgg = oggAbbigliamentoService.restock(id, amount);
        if (optionalOgg.isPresent()) {
            return ResponseEntity.ok().body(optionalOgg.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
