package com.cb.baya.transport.transporter;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface TransporterService {

  Transporter register(Transporter transporter);

  Optional<Transporter> findByMsisdn(String msidn);

  Optional<Transporter> findById(long id);

  List<Transporter> findByLastName(String lastName);

  List<Transporter> findByFirstName(String firstName);


  Long total();

  Transporter update(Transporter transporter);

  List<Transporter> findAll(Pageable pageable);
}
