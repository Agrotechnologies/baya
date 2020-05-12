package com.cb.baya.tsp;


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
@RequestMapping("/tsp")
public class ServiceProviderApi implements CrudApi<ServiceProviderDto> {

  private final ServiceProviderService serviceProviderService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<ServiceProviderDto> register(@Valid @RequestBody ServiceProviderDto providerDto) {
    log.info("New Registration : {} ", providerDto);
    final ServiceProvider serviceProvider = serviceProviderService.register(mapper.map(providerDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(serviceProvider));
  }

  @GetMapping(value = "/find/{msisdn}")
  public ApiResponse<ServiceProviderDto> findServiceProvider(@PathVariable(name = "msisdn") final String msisdn) {
    final Optional<ServiceProvider> tractorServiceProvider = serviceProviderService.findByMsisdn(msisdn);
    return tractorServiceProvider.map(tsp -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(tsp)))
      .orElseThrow(() -> new BusinessException("Service provider with msisdn " + msisdn + "not found"));
  }

  @Override
  public ApiResponse<ServiceProviderDto> create(ServiceProviderDto providerDto) {
    log.info("New Registration : {} ", providerDto);
    final ServiceProvider serviceProvider = serviceProviderService.register(mapper.map(providerDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(serviceProvider));
  }

  @Override
  public ApiResponse<ServiceProviderDto> update(ServiceProviderDto serviceProviderDto) {
    log.info("Update Tractor Service Provider : {} ", serviceProviderDto);
    final ServiceProvider serviceProvider = serviceProviderService.update(mapper.map(serviceProviderDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(serviceProvider));
  }

  @Override
  public ApiResponse<ServiceProviderDto> delete(ServiceProviderDto serviceProviderDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<ServiceProviderDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<ServiceProviderDto> tspDtos = serviceProviderService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<ServiceProviderDto> pagedTsp = PaginationResult.pagination(tspDtos, serviceProviderService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedTsp);
  }

  @Override
  public ApiResponse<ServiceProviderDto> find(final Long id) {
    final Optional<ServiceProvider> tractorServiceProvider = serviceProviderService.findById(id);
    return tractorServiceProvider.map(tsp -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(tsp)))
      .orElseThrow(() -> new BusinessException("Service provider with Id " + id + "not found"));
  }
}
