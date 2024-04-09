package com.assignment.irctc.booking;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TrainBookingDetails {
    public TrainBookingDetails() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long trainId;
    private String source;
    private String destination;
    private String travellername;

    public TrainBookingDetails(Long id, Long trainId, String source, String destination, String travellername, Long fair) {
        this.id = id;
        this.trainId = trainId;
        this.source = source;
        this.destination = destination;
        this.travellername = travellername;
        this.fair = fair;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTravellername() {
        return travellername;
    }

    public void setTravellername(String travellername) {
        this.travellername = travellername;
    }

    public Long getFair() {
        return fair;
    }

    public void setFair(Long fair) {
        this.fair = fair;
    }

    private Long fair;
}

