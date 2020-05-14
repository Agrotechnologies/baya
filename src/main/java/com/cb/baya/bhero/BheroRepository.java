package com.cb.baya.bhero;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BheroRepository extends JpaRepository<Bhero, Long> {

  Optional<Bhero> findByBellNo(int bellNo);

  List<Bhero> findByClassification(String clasification);

  List<Bhero> findByBellStatus(String bellStatus);


}
