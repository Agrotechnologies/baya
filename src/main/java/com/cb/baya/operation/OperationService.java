package com.cb.baya.operation;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OperationService {

  Operation createOperation(Operation operation);

  Optional<Operation> findByName(String name);

  Optional<Operation> findById(Long id);

  List<Operation> findAll();

  void delete(Operation operation);

  Long total();

  List<Operation> findAll(Pageable pageable);
}
