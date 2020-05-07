package com.cb.baya.operation;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/operation")
public class OperationApi implements CrudApi<OperationDto> {

  private final TypeMapper mapper;
  private final OperationService operationService;

  @Override
  public ApiResponse<OperationDto> create(OperationDto operationDto) {
    log.info("Create operation : {}", operationDto);
    final Operation operationCreated = operationService.createOperation(mapper.map(operationDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(operationCreated));
  }

  @Override
  public ApiResponse<OperationDto> update(OperationDto operationDto) {
    log.info("Create operation : {}", operationDto);
    final Operation operationCreated = operationService.createOperation(mapper.map(operationDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(operationCreated));
  }

  @Override
  public ApiResponse<OperationDto> delete(OperationDto operationDto) {
//        throw new NotImplementedException();
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<OperationDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    log.info("find all Operation ");
    final List<OperationDto> operationDtos = operationService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    return new ApiResponse<>(HttpStatus.OK.value(), PaginationResult.pagination(operationDtos, operationService.total(), page, size));
  }

  @Override
  public ApiResponse<OperationDto> find(Long id) {
    Optional<Operation> operationRecord = operationService.findById(id);
    return new ApiResponse<>(HttpStatus.OK.value(),
      mapper.map(operationRecord.orElseThrow(() -> new BusinessException("Could not find operation with id " + id))));
  }


}
