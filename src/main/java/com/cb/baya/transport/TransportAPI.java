package com.cb.baya.transport;

import com.cb.baya.common.ApiResponse;
import com.cb.baya.common.CrudApi;
import com.cb.baya.common.PaginationResult;
import com.cb.baya.config.TypeMapper;
import com.sun.jdi.connect.spi.TransportService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/transport")
public class TransportAPI implements CrudApi<TransportDto> {

  private final TransportService transportService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<TransportDto> register(@Valid @RequestBody Transport transportDto) {
    log.info("New Registration Transporter : {} ", transportDto);
    // final Transport transport = transportService.register(mapper.map(transportDto));
    // return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(transport));
    return null;
  }

  @Override
  public ApiResponse<TransportDto> create(TransportDto transportDto) {
    return null;
  }

  @Override
  public ApiResponse<TransportDto> update(TransportDto transportDto) {
    return null;
  }

  @Override
  public ApiResponse<TransportDto> delete(TransportDto transportDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<TransportDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    return null;
  }

  @Override
  public ApiResponse<TransportDto> find(Long id) {
    return null;
  }
}
