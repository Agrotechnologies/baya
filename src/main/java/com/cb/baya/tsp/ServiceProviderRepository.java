package com.cb.baya.tsp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {

  Optional<ServiceProvider> findByMsisdn(String msisdn);

  List<ServiceProvider> findByLastName(String lastName);

  List<ServiceProvider> findByFirstName(String firstName);
}
