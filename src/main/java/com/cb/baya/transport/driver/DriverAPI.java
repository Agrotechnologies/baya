package com.cb.baya.transport.driver;

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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/driver")

public class DriverAPI implements CrudApi<DriverDto> {

  private final DriverService driverService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<DriverDto> register(@Valid @RequestBody DriverDto driverDto) {
    log.info("New Registration Driver: {} ", driverDto);
    final Driver driver = driverService.register(mapper.map(driverDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(driver));
  }

  @GetMapping(value = "/find/{msisdn}")
  public ApiResponse<DriverDto> findServiceProvider(@PathVariable(name = "msisdn") final String msisdn) {
    final Optional<Driver> driver = driverService.findByMsisdn(msisdn);
    return driver.map(driver1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(driver1)))
      .orElseThrow(() -> new BusinessException("Driver with msisdn " + msisdn + "not found"));
  }


  @Override
  public ApiResponse<DriverDto> create(DriverDto driverDto) {
    log.info("New Registration : {} ", driverDto);
    final Driver driver = driverService.register(mapper.map(driverDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(driver));
  }

  @Override
  public ApiResponse<DriverDto> update(DriverDto driverDto) {
    log.info("Update Driver : {} ", driverDto);
    final Driver driver = driverService.update(mapper.map(driverDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(driver));
  }

  @Override
  public ApiResponse<DriverDto> delete(DriverDto driverDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<DriverDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<DriverDto> driverDtos = driverService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<DriverDto> pagedDrivers = PaginationResult.pagination(driverDtos, driverService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedDrivers);
  }

  @Override
  public ApiResponse<DriverDto> find(Long id) {
    final Optional<Driver> driver = driverService.findById(id);
    return driver.map(driver1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(driver1)))
      .orElseThrow(() -> new BusinessException("Service provider with Id " + id + "not found"));
  }
}
