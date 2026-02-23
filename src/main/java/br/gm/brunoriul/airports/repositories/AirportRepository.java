package br.gm.brunoriul.airports.repositories;

import br.gm.brunoriul.airports.entities.Airport;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    
    List<Airport> findByCityIgnoreCase(String city);
    
}
