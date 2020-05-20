package com.cb.baya.transport;

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
@RequestMapping("/transport")
public class TransportAPI implements CrudApi<TransportDto> {

  private final TransportingService transportingService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<TransportDto> register(@Valid @RequestBody TransportDto transportDto) {
    log.info("New Registration Transporter : {} ", transportDto);
    final Transport transport = transportingService.register(mapper.map(transportDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(transport));

  }

  @GetMapping(value = "/find/{regNumber}")
  public ApiResponse<TransportDto> findRegNumber(@PathVariable(name = "regNumber") final String regNumber) {
    final Optional<Transport> transport = transportingService.findByRegNumber(regNumber);
    return transport.map(tsp -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(tsp)))
      .orElseThrow(() -> new BusinessException("Transport  with RegNumber " + regNumber + "not found"));
  }


  @Override
  public ApiResponse<TransportDto> create(TransportDto transportDto) {

    log.info("New Registration : {} ", transportDto);
    final Transport transport = transportingService.register(mapper.map(transportDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(transport));
  }

  @Override
  public ApiResponse<TransportDto> update(TransportDto transportDto) {
    log.info("Update Transport : {} ", transportDto);
    final Transport transport = transportingService.update(mapper.map(transportDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(transport));
  }

  @Override
  public ApiResponse<TransportDto> delete(TransportDto transportDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<TransportDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<TransportDto> tspDtos = transportingService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<TransportDto> pagedTsp = PaginationResult.pagination(tspDtos, transportingService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedTsp);
  }

  @Override
  public ApiResponse<TransportDto> find(Long id) {
    final Optional<Transport> transport = transportingService.findById(id);
    return transport.map(tsp -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(tsp)))
      .orElseThrow(() -> new BusinessException("Transporter with Id " + id + "not found"));

  }
}
