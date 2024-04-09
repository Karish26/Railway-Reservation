package com.assignment.irctc.train;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    private TrainRepository trainRepository;

    // Method to add a new train
    public Train addTrain(TrainDTO trainDTO) {
        Train train = new Train(trainDTO.getName(), trainDTO.getSource(), trainDTO.getDestination(), trainDTO.getTotalSeats(), trainDTO.getTotalSeats());
        return trainRepository.save(train);
    }

    // Method to update the number of seats in a train
    public Train updateSeats(Long trainId, int newTotalSeats) {
        Train train = trainRepository.findById(trainId)
                .orElseThrow(() -> new RuntimeException("Train not found with id: " + trainId));

        train.setTotalSeats(newTotalSeats);
        train.setAvailableSeats(newTotalSeats); // Assuming available seats also get updated
        return trainRepository.save(train);
    }
}
