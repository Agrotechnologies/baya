package com.cb.baya.farmer.bell;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BellRepository extends JpaRepository<Bell, Long> {

  Optional<Bell> findByClassification(String classification);
}
