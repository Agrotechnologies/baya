package com.cb.baya.trip;

import com.cb.baya.common.ApiResponse;
import com.cb.baya.common.CrudApi;
import com.cb.baya.common.PaginationResult;
import com.cb.baya.config.TypeMapper;
import com.cb.baya.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/trip")

public class TripApi implements CrudApi<TripDto> {

  private final TripService tripService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<TripDto> register(@Valid @RequestBody TripDto tripDto) {
    log.info("New Registration : {} ", tripDto);
    final Trip trip = tripService.register(mapper.map(tripDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(trip));
  }

//  @GetMapping(value = "/find/{status}")
//  public ApiResponse<TripDto> findTripStatus(@PathVariable(name = "status") final TripStatus status) {
//    final Optional<Trip> trip = Optional.ofNullable(tripService.findByTripStatus(status));
//    return trip.map(tsp -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(tsp)))
//      .orElseThrow(() -> new BusinessException("Trip with id " + status + "not found"));
//  }

  @Override
  public ApiResponse<TripDto> create(TripDto tripDto) {
    log.info("New Registration : {} ", tripDto);
    final Trip trip = tripService.register(mapper.map(tripDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(trip));
  }

  @Override
  public ApiResponse<TripDto> update(TripDto tripDto) {

    log.info("Update Trip : {} ", tripDto);
    final Trip trip = tripService.update(mapper.map(tripDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(trip));
  }

  @Override
  public ApiResponse<TripDto> delete(TripDto tripDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<TripDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<TripDto> tripDtos = tripService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<TripDto> pagedTrip = PaginationResult.pagination(tripDtos, tripService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedTrip);
  }

  @Override
  public ApiResponse<TripDto> find(Long id) {

    final Optional<Trip> trip = tripService.findById(id);
    return trip.map(trip1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(trip1)))
      .orElseThrow(() -> new BusinessException("Trip with Id " + id + "not found"));
  }
}
