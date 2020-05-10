package com.cb.baya.farmer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {

  Optional<Farmer> findByMsisdn(String msisdn);

  Optional<Farmer> findByGrowerNo(String growerNo);

  List<Farmer> findByLastName(String lastName);

  List<Farmer> findByFirstName(String firstName);
}
