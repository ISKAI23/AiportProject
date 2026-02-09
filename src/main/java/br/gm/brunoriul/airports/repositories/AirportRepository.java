package br.gm.brunoriul.airports.repositories;

import br.gm.brunoriul.airports.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    
}
