package com.assignment.irctc.booking;

import lombok.AllArgsConstructor;
import lombok.Data;

public class TrainBookingResponse {
    private String message;

    public TrainBookingResponse(String message, String bookingId) {
        this.message = message;
        this.bookingId = bookingId;
    }

    private String bookingId;
}

