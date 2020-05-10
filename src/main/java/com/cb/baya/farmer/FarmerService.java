package com.cb.baya.farmer;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FarmerService {

  Farmer register(Farmer farmer);

  Optional<Farmer> findByGrowerNo(String growerNo);

  Optional<Farmer> findByMsisdn(String msidn);

  Optional<Farmer> findById(long id);

  List<Farmer> findByLastName(String lastName);

  List<Farmer> findByFirstName(String firstName);

  Long total();

  Farmer update(Farmer farmer);

  List<Farmer> findAll(Pageable pageable);
}
