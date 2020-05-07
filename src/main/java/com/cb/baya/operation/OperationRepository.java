package com.cb.baya.operation;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationRepository extends JpaRepository<Operation, Long> {

  Optional<Operation> findByName(String name);
}
