package com.cb.baya.serviceimplement;


import com.cb.baya.common.ApiResponse;
import com.cb.baya.common.CrudApi;
import com.cb.baya.common.PaginationResult;
import com.cb.baya.config.TypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/implement")
public class ServiceImplementsApi implements CrudApi<ServiceImplementDto> {

  private final ServiceImplementService serviceImplementService;
  private final TypeMapper mapper;

  @GetMapping
  public ApiResponse<List<ServiceImplementDto>> findAll() {
    List<ServiceImplementDto> serviceImplementDtos = serviceImplementService.findAll()
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());
    return new ApiResponse<>(HttpStatus.OK.value(), serviceImplementDtos);
  }


  @Override
  public ApiResponse<ServiceImplementDto> create(ServiceImplementDto serviceImplementDto) {
    log.info("New Tractor Implement : {} ", serviceImplementDto);
    final ServiceImplement serviceImplement = serviceImplementService.register(mapper.map(serviceImplementDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(serviceImplement));

  }

  @Override
  public ApiResponse<ServiceImplementDto> update(ServiceImplementDto serviceImplementDto) {
    log.info("Updating Tractor Implement : {} ", serviceImplementDto);
    final ServiceImplement serviceImplement = serviceImplementService.update(mapper.map(serviceImplementDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(serviceImplement));
  }

  @Override
  public ApiResponse<ServiceImplementDto> delete(ServiceImplementDto serviceImplementDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<ServiceImplementDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    return null;
  }

  @Override
  public ApiResponse<ServiceImplementDto> find(Long id) {
    return null;
  }
}
