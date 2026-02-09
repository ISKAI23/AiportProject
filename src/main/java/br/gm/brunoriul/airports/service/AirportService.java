package br.gm.brunoriul.airports.service;


import br.gm.brunoriul.airports.entities.Airport;
import br.gm.brunoriul.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportService {
    
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll() {
        
        List<Airport> result = airportRepository.findAll();
        return result;
    }
    
    
}
