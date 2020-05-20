package com.cb.baya.trip;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)

public class TripServiceImpl implements TripService {

  private final TripRepository tripRepository;

  @Override
  public Trip register(Trip trip) {

    log.info("Register Trip :{}", trip);
    return tripRepository.save(trip);
  }

//  @Override
//  public Trip findByTripStatus(TripStatus tripStatus) {
//    return tripRepository.findByTripStatus(tripStatus);
//  }

  @Override
  public Optional<Trip> findById(long id) {
    return tripRepository.findById(id);
  }

  @Override
  public Long total() {
    return tripRepository.count();
  }

  @Override
  public Trip update(Trip trip) {

    log.info("Updating the Trip :{}", trip);
    return tripRepository.save(trip);
  }

  @Override
  public List<Trip> findAll(Pageable pageable) {
    return tripRepository.findAll(pageable).getContent();
  }
}
