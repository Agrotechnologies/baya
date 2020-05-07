package com.cb.baya.operation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OperationServiceImpl implements OperationService {

  private final OperationRepository operationRepository;

  @Override
  public Operation createOperation(Operation operation) {
    return operationRepository.save(operation);
  }

  @Override
  public Optional<Operation> findByName(String name) {
    return Optional.empty();
  }

  @Override
  public Optional<Operation> findById(Long id) {
    return operationRepository.findById(id);
  }

  @Override
  public List<Operation> findAll() {
    return operationRepository.findAll();
  }

  @Override
  public void delete(Operation operation) {
    operationRepository.delete(operation);
  }

//    @Override
//    public List<Operation> findAll(Integer page, Integer size, String sortBy) {
//        return operationRepository.findAll(PageRequest.of(--page, size, Sort.by(sortBy))).getContent();
//    }

  @Override
  public Long total() {
    return operationRepository.count();
  }

  @Override
  public List<Operation> findAll(Pageable pageable) {
    return operationRepository.findAll(pageable).getContent();
  }


}
