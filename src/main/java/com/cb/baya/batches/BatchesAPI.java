package com.cb.baya.batches;

import com.cb.baya.bhero.BellStatus;
import com.cb.baya.bhero.Bhero;
import com.cb.baya.bhero.BheroRepository;
import com.cb.baya.bhero.BheroService;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/batches")

public class BatchesAPI implements CrudApi<BatchesDto> {

  private final BatchService batchService;
  private final BheroService bheroService;
  private final BheroRepository bheroRepository;
  private final TypeMapper mapper;

  @PostMapping(value = "/register")
  public ApiResponse<BatchesDto> register(@Valid @RequestBody BatchesDto batchesDto) {

    log.info("New Batch Creation : {} ", batchesDto);
    String classification = "Spanngy";
    bheroService.findByClassification(classification);
    log.info("List of Bells : {} ", bheroService);
    List<Bhero> bhero = new ArrayList<>();
    bhero.addAll(bheroService.findByClassification(classification));
    List<Long> bellIds = bhero.stream()
      .map(Bhero::getId).collect(Collectors.toList());
    Collections.sort(bellIds);
    final Batches batches = batchService.register(mapper.map(batchesDto));
    for (Long i : bellIds) {
      Bhero bello = new Bhero();
      bello.setBatches(batches);
      bello.setBellStatus(BellStatus.BATCHED);
      bheroService.update(bello);
    }

    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(batches));

  }

  @GetMapping(value = "/find/{batchNo}")
  public ApiResponse<BatchesDto> findServiceProvider(@PathVariable(name = "batchNo") final String batchNo) {
    final Optional<Batches> batches = batchService.findByBatchNo(batchNo);
    return batches.map(batch -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(batch)))
      .orElseThrow(() -> new BusinessException("Batch with BatchNo " + batchNo + "not found"));
  }


  @Override
  public ApiResponse<BatchesDto> create(BatchesDto batchesDto) {
    log.info("New Batch Register : {} ", batchesDto);
    final Batches batches = batchService.register(mapper.map(batchesDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(batches));
  }


  @Override
  public ApiResponse<BatchesDto> update(BatchesDto batchesDto) {
    log.info("Update the Batches : {} ", batchesDto);
    final Batches batches = batchService.register(mapper.map(batchesDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(batches));
  }

  @Override
  public ApiResponse<BatchesDto> delete(BatchesDto batchesDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<BatchesDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<BatchesDto> bellDtos = batchService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<BatchesDto> pagedBatches = PaginationResult.pagination(bellDtos, batchService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedBatches);
  }

  @Override
  public ApiResponse<BatchesDto> find(Long id) {

    final Optional<Batches> batches = batchService.findById(id);
    return batches.map(batch -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(batch)))
      .orElseThrow(() -> new BusinessException("Service provider with Id " + id + "not found"));
  }
}
