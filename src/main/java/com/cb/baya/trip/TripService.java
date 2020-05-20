package com.cb.baya.trip;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface TripService {


  Trip register(Trip trip);

//  Trip findByTripStatus(TripStatus tripStatus);

  Optional<Trip> findById(long id);


  Long total();

  Trip update(Trip trip);

  List<Trip> findAll(Pageable pageable);


}
