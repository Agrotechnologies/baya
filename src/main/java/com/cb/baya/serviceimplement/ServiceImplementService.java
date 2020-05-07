package com.cb.baya.serviceimplement;

import java.util.List;

public interface ServiceImplementService {

//    Optional<TractorImplement> findByRegistrationNumber(String registrationNumber);

  List<ServiceImplement> findByServiceProviderMsisdn(String msisdn);

  List<ServiceImplement> findAll(int pageCount);

  List<ServiceImplement> findAll();

  ServiceImplement register(ServiceImplement serviceImplement);

  ServiceImplement update(ServiceImplement serviceImplement);
}
