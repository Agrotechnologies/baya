package com.cb.baya.transport.driver;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DriverRepository extends JpaRepository<Driver, Long> {

  Optional<Driver> findByMsisdn(String msisdn);

  Optional<Driver> findByDriverLicenceNo(String driverLicenceNo);

  List<Driver> findBySurname(String surname);

  List<Driver> findByName(String name);
}
