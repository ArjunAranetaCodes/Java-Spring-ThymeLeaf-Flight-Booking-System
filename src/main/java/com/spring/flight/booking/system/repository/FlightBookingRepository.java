package com.spring.flight.booking.system.repository;

import com.spring.flight.booking.system.model.FlightBooking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightBookingRepository extends JpaRepository<FlightBooking, Long> {
}

