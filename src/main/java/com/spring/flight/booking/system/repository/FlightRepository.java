package com.spring.flight.booking.system.repository;

import com.spring.flight.booking.system.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Add custom query methods here, if needed
}

