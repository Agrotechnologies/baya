package com.cb.baya.bhero;

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

public class BheroAPI implements CrudApi<BheroDto> {


  private final BheroService bheroService;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<BheroDto> register(@Valid @RequestBody BheroDto bheroDto) {
    log.info("New Registration : {} ", bheroDto);
    final Bhero bhero = bheroService.register(mapper.map(bheroDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bhero));
  }

  @GetMapping(value = "/find/{bellNo}")
  public ApiResponse<BheroDto> findServiceProvider(@PathVariable(name = "bellNo") final int bellNo) {
    final Optional<Bhero> bhero = bheroService.findByBellNo(bellNo);
    return bhero.map(bell -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bell)))
      .orElseThrow(() -> new BusinessException("Service provider with bellNo " + bellNo + "not found"));
  }

  @Override
  public ApiResponse<BheroDto> create(BheroDto bheroDto) {
    log.info("New Registration : {} ", bheroDto);
    final Bhero bhero = bheroService.register(mapper.map(bheroDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bhero));
  }

  @Override
  public ApiResponse<BheroDto> update(BheroDto bheroDto) {

    log.info("Update Bell Information : {} ", bheroDto);
    final Bhero bhero = bheroService.update(mapper.map(bheroDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bhero));
  }

  @Override
  public ApiResponse<BheroDto> delete(BheroDto bheroDto) {
    return null;
  }


  @Override
  public ApiResponse<PaginationResult<BheroDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<BheroDto> bellDto = bheroService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<BheroDto> pagedBells = PaginationResult.pagination(bellDto, bheroService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedBells);
  }

  @Override
  public ApiResponse<BheroDto> find(Long id) {
    final Optional<Bhero> bhero = bheroService.findById(id);
    return bhero.map(bell -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(bell)))
      .orElseThrow(() -> new BusinessException("Bhero with Id " + id + "not found"));
  }
}

