package com.cb.baya.transport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TransportRepository extends JpaRepository<Transport, Long> {

  Optional<Transport> findByRegNumber(String regNumber);
}
