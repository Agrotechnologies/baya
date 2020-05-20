package com.cb.baya.transport;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface TransportService {


  Transport register(Transport transport);

  Optional<Transport> findByRegNumber(String regNumber);

  Optional<Transport> findById(long id);


  Long total();

  Transport update(Transport transport);

  List<Transport> findAll(Pageable pageable);

}
