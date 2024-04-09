package com.assignment.irctc.train;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1/train")
public class TrainController {
    @Autowired
    private TrainService trainService;

    // Endpoint to add a new train by an admin user
    @PostMapping("/add")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> addTrain(@RequestBody TrainDTO trainDTO) {
        Train train = trainService.addTrain(trainDTO);
        return ResponseEntity.ok(train);
    }

    // Endpoint to update the number of seats in a train by an admin user
    @PutMapping("/{trainId}/seats")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> updateSeats(@PathVariable Long trainId, @RequestParam int newTotalSeats) {
        Train train = trainService.updateSeats(trainId, newTotalSeats);
        return ResponseEntity.ok(train);
    }

}
