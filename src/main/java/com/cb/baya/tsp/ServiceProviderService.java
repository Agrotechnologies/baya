package com.cb.baya.tsp;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceProviderService {

  ServiceProvider register(ServiceProvider provider);

  Optional<ServiceProvider> findByMsisdn(String msidn);

  Optional<ServiceProvider> findById(long id);

  List<ServiceProvider> findByLastName(String lastName);

  List<ServiceProvider> findByFirstName(String firstName);

  //List<TractorServiceProvider> findAll(int page, int size, String sortBy);

  Long total();

  ServiceProvider update(ServiceProvider serviceProvider);

  List<ServiceProvider> findAll(Pageable pageable);
}
