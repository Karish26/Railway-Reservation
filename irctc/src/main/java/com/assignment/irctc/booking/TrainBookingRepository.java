package com.assignment.irctc.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainBookingRepository extends JpaRepository<TrainBookingDetails, Long> {
}
