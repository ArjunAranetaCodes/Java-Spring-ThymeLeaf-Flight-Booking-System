package com.spring.flight.booking.system.controller;

import com.spring.flight.booking.system.model.Flight;
import com.spring.flight.booking.system.model.FlightBooking;
import com.spring.flight.booking.system.repository.FlightBookingRepository;
import com.spring.flight.booking.system.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class FlightController {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightBookingRepository flightBookingRepository;

    @GetMapping("/")
    public String redirectToFlights() {
        return "redirect:/flights";
    }
    @GetMapping("/flights")
    public String getFlightsPage(Model model, @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size,
                                 @RequestParam(defaultValue = "id") String sortField,
                                 @RequestParam(defaultValue = "asc") String sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.fromString(sortDirection), sortField));
        Page<Flight> flights = flightRepository.findAll(pageable);
        model.addAttribute("flights", flights);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDirection", sortDirection);
        return "flights";
    }

    @GetMapping("/flights/{id}")
    public String getFlightDetails(@PathVariable Long id, Model model) {
        Flight flight = flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not found"));
        model.addAttribute("flight", flight);
        model.addAttribute("flightBooking", new FlightBooking());
        return "flight-details";
    }

    @PostMapping("/flights/book")
    public String bookFlight(@ModelAttribute FlightBooking flightBooking, @RequestParam Long flightId,
                             RedirectAttributes redirectAttributes) {
        try {
            // Fetch the flight from the database
            Optional<Flight> optionalFlight = flightRepository.findById(flightId);
            if (optionalFlight.isEmpty()) {
                redirectAttributes.addFlashAttribute("errorMessage", "The flight is no longer available.");
                return "redirect:/flights";
            }
            Flight flight = optionalFlight.get();

            // Create a new flight booking
            flightBooking.setFlight(flight);
            flightBooking.setBookingDate(LocalDateTime.now());
            flightBookingRepository.save(flightBooking);

            redirectAttributes.addFlashAttribute("successMessage", "Flight booked successfully!");
            return "redirect:/flights";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while booking the flight.");
            return "redirect:/flights";
        }
    }

    @GetMapping("/bookings")
    public String getBookingsPage(Model model) {
        List<FlightBooking> bookings = flightBookingRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "bookings";
    }
}

