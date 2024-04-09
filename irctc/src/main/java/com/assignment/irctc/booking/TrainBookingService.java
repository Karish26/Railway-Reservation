package com.assignment.irctc.booking;

import com.assignment.irctc.train.Train;
import com.assignment.irctc.train.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainBookingService {

    @Autowired
    private TrainBookingRepository trainBookingRepository;
    @Autowired
    private TrainRepository trainRepository;
    public TrainBookingResponse bookTrain(TrainBookingRequest bookingRequest) {
        Train train = trainRepository.findBySourceAndDestination(bookingRequest.getSource(), bookingRequest.getDestination());
        if(train==null) return new TrainBookingResponse("No train found btw given stations","Booking id not available");
        if(train.getAvailableSeats()<bookingRequest.getNoOfSeats()) return new TrainBookingResponse("seats not available in the train","booking id not available");
        train.setAvailableSeats((int) (train.getAvailableSeats()-bookingRequest.getNoOfSeats()));
        trainRepository.save(train);
        TrainBookingDetails trainBookingDetails = new TrainBookingDetails();
        trainBookingDetails.setTrainId(train.getId());
        trainBookingDetails.setDestination(bookingRequest.getDestination());
        trainBookingDetails.setSource(bookingRequest.getSource());
        trainBookingDetails.setFair(100L);
        trainBookingDetails.setTravellername(bookingRequest.getTravellerName());
        trainBookingDetails = trainBookingRepository.save(trainBookingDetails);
        return new TrainBookingResponse("Booking successful", "Your booking ID is:"+trainBookingDetails.getId());
    }

    // Method to get booking details
    public TrainBookingDetails getBookingDetails(Long bookingId) {
        // Retrieve booking details from the repository based on the booking ID
        // You can return a response containing the booking details
        return trainBookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found with id: " + bookingId));
    }
}
