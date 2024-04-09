package com.assignment.irctc.train;

import lombok.Data;

@Data
public class TrainDTO {

    private String name;
    private String source;
    private String destination;
    private int totalSeats;
}
