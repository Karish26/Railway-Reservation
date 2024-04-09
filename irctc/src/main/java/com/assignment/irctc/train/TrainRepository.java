package com.assignment.irctc.train;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train, Long> {
    Train findBySourceAndDestination(String source, String destination);
}