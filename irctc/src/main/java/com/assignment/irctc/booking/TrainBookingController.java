package com.assignment.irctc.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class TrainBookingController {

    @Autowired
    private TrainBookingService trainBookingService;

    @PostMapping("/book")
    public ResponseEntity<?> bookTrain(@RequestBody TrainBookingRequest bookingRequest) {
        TrainBookingResponse bookingResponse = trainBookingService.bookTrain(bookingRequest);
        return ResponseEntity.ok(bookingResponse);
    }

    // Endpoint to get booking details
    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingDetails(@PathVariable Long bookingId) {
        TrainBookingDetails bookingDetails = trainBookingService.getBookingDetails(bookingId);
        return ResponseEntity.ok(bookingDetails);
    }
}