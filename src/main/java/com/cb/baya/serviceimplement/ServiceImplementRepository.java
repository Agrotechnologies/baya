package com.cb.baya.serviceimplement;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceImplementRepository extends JpaRepository<ServiceImplement, Long> {

//    Optional<TractorImplement>findByRegistrationNumber(String registrationNumber);
}
