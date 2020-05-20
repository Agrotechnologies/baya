package com.cb.baya.transport.driver;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DriverService {

  Driver register(Driver driver);

  Optional<Driver> findByDriverLicenceNo(String driverLicenceNo);

  Optional<Driver> findByMsisdn(String msisdn);


  Optional<Driver> findById(long id);

  List<Driver> findBySurname(String surname);

  List<Driver> findByName(String name);

  Long total();

  Driver update(Driver driver);

  List<Driver> findAll(Pageable pageable);


}
