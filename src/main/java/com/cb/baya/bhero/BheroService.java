package com.cb.baya.bhero;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BheroService {

  Bhero register(Bhero bhero);

  Optional<Bhero> findByBellNo(int bellNo);

  Optional<Bhero> findById(long id);

  List<Bhero> findByClassification(String classsification);

  List<Bhero> findByBellStatus(String bellStatus);

  Long total();

  Bhero update(Bhero bhero);

  List<Bhero> findAll(Pageable pageable);
}
