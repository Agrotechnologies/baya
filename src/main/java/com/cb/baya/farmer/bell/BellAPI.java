package com.cb.baya.farmer.bell;

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
@RequestMapping("/bell")
public class BellAPI implements CrudApi<BellDto> {

  private final BellService bellService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<BellDto> register(@Valid @RequestBody BellDto bellDto) {

    log.info("New Registration : {} ", bellDto);
    final Bell bell = bellService.register(mapper.map(bellDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bell));
  }

  @GetMapping(value = "/find/{id")
  public ApiResponse<BellDto> findBell(@PathVariable(name = "id") final int id) {
    final Optional<Bell> bell = bellService.findById(id);
    return bell.map(bell1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bell1)))
      .orElseThrow(() -> new BusinessException("Service provider with  " + id + "not found"));
  }


  @Override
  public ApiResponse<BellDto> create(BellDto bellDto) {

    log.info("New Registration : {} ", bellDto);
    final Bell bell = bellService.register(mapper.map(bellDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bell));
  }

  @Override
  public ApiResponse<BellDto> update(BellDto bellDto) {

    log.info("Update Existing Bell : {} ", bellDto);
    final Bell bell = bellService.update(mapper.map(bellDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bell));
  }

  @Override
  public ApiResponse<BellDto> delete(BellDto bellDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<BellDto>> findAll(String search, Integer page, Integer size, String sortBy) {

    List<BellDto> bellDtos = bellService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<BellDto> pagedBells = PaginationResult.pagination(bellDtos, bellService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedBells);

  }

  @Override
  public ApiResponse<BellDto> find(Long id) {
    final Optional<Bell> bell = bellService.findById(id);
    return bell.map(bell1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bell1)))
      .orElseThrow(() -> new BusinessException("Bell with Id " + id + "not found"));
  }
}
