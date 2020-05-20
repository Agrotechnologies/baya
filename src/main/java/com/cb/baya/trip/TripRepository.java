package com.cb.baya.trip;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripRepository extends JpaRepository<Trip, Long> {

//  Trip findByTripStatus(TripStatus tripStatus);
}
