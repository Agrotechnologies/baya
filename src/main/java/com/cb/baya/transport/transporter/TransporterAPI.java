package com.cb.baya.transport.transporter;

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
@RequestMapping("/transporter")

public class TransporterAPI implements CrudApi<TransporterDto> {

  private final TransporterService transporterService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<TransporterDto> register(@Valid @RequestBody TransporterDto transporterDto) {
    log.info("New Registration Transporter : {} ", transporterDto);
    final Transporter transporter = transporterService.register(mapper.map(transporterDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(transporter));
  }

  @GetMapping(value = "/find/{msisdn}")
  public ApiResponse<TransporterDto> findServiceProvider(@PathVariable(name = "msisdn") final String msisdn) {
    final Optional<Transporter> transporter = transporterService.findByMsisdn(msisdn);
    return transporter.map(tsp -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(tsp)))
      .orElseThrow(() -> new BusinessException("Transporter Service provider with msisdn " + msisdn + "not found"));
  }


  @Override
  public ApiResponse<TransporterDto> create(TransporterDto transporterDto) {
    log.info("New Registration : {} ", transporterDto);
    final Transporter transporter = transporterService.register(mapper.map(transporterDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(transporter));
  }


  @Override
  public ApiResponse<TransporterDto> update(TransporterDto transporterDto) {
    log.info("Update Tractor Service Provider : {} ", transporterDto);
    final Transporter transporter = transporterService.update(mapper.map(transporterDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(transporter));
  }

  @Override
  public ApiResponse<TransporterDto> delete(TransporterDto transporterDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<TransporterDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<TransporterDto> tspDtos = transporterService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<TransporterDto> pagedTsp = PaginationResult.pagination(tspDtos, transporterService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedTsp);
  }

  @Override
  public ApiResponse<TransporterDto> find(Long id) {
    final Optional<Transporter> transporter = transporterService.findById(id);
    return transporter.map(tsp -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(tsp)))
      .orElseThrow(() -> new BusinessException("Service provider with Id " + id + "not found"));
  }
}
