package com.cb.baya.transport.transporter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransporterRepository extends JpaRepository<Transporter, Long> {

  Optional<Transporter> findByMsisdn(String msisdn);

  List<Transporter> findByLastName(String lastName);

  List<Transporter> findByFirstName(String firstName);


}
