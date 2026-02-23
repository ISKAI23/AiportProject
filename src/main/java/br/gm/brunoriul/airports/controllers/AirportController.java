package br.gm.brunoriul.airports.controllers;

import br.gm.brunoriul.airports.DTO.AirportMinDTO;
import br.gm.brunoriul.airports.DTO.AirportNearMeDTO;
import br.gm.brunoriul.airports.entities.Airport;
import br.gm.brunoriul.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    @Autowired
    private AirportService airportService;

    /**
     * Endpoint /airports/airport Retorna TODOS os aeroportos da base de dados.
     *
     * @return
     */
    @GetMapping("/airport")
    public List<Airport> findAll() {
        List<Airport> result = airportService.findAll();
        return result;
    }

    /**
     * Endpoint /airports/city/{cityName} preparado para devlver código dee
     * status conforme padronização RES
     *
     * @param cityName
     * @return
     */
    @GetMapping("/city/{cityName}")
    public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {
        List<Airport> result = airportService.findByCity(cityName);

        if (result.isEmpty()) {
            // Ops... Linha vazia...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Eba! tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }

    @GetMapping("/country/{countryName}")
    public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {
        List<AirportMinDTO> result = airportService.findByCountry(countryName);

        if (result.isEmpty()) {
            // Ops... Linha vazia...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
        } else {
            // Eba! tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
    
    @GetMapping("/iatacode/{iataCode}")
    public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
        Airport result = airportService.findByIataCode(iataCode);

        if (result == null) {
            // Ops... Aeroporto vazio...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            // Eba! tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
    
    
    @GetMapping("/nearme")
    public ResponseEntity<List<AirportNearMeDTO>> findNearMe(@RequestParam double latitude, @RequestParam double longitude) {
        
        List<AirportNearMeDTO> result = airportService.finNearMe(latitude, longitude);

        if (result.isEmpty()) {
            // Ops... Aeroporto vazio...
            // notFound devolve 404
            return ResponseEntity.notFound().build();
            
        } else {
            // Eba! tem dados!
            // ok devolve 200
            return ResponseEntity.ok(result);
        }
    }
    
}
