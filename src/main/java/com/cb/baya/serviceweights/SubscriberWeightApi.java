package com.cb.baya.serviceweights;

import com.cb.baya.common.ApiResponse;
import com.cb.baya.config.TypeMapper;
import com.cb.baya.exception.BusinessException;
import com.cb.baya.tsp.ServiceProvider;
import com.cb.baya.tsp.ServiceProviderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/subscriber")
@Slf4j
@RequiredArgsConstructor
public class SubscriberWeightApi {

  private final SubscriberWeightsService subscriberWeightsService;
  private final TypeMapper typeMapper;
  private final ServiceProviderService tractorServiceProviderService;

  @GetMapping(value = "/points/{msisdn}")
  public ApiResponse<SubscriberWeightsDto> findPoints(@PathVariable("msisdn") String msisdn) {

    log.debug("finding subscriber weights for servicesprovider {}", msisdn);
    final Optional<SubscriberWeights> subscriberPointsOptional = subscriberWeightsService.findByMsisdn(msisdn);
    final SubscriberWeightsDto subscriberWeightsDto = subscriberPointsOptional.map(typeMapper::map)
      .orElseThrow(() -> new BusinessException("Subscriber " + msisdn + "is not registered for this service"));
    final ServiceProvider tractorServiceProvider = tractorServiceProviderService.findByMsisdn(msisdn)
      .orElseThrow(() -> new BusinessException("Subscriber " + msisdn + "is not registered for this service"));
    subscriberWeightsDto.setFirstName(tractorServiceProvider.getFirstName());
    subscriberWeightsDto.setLastName(tractorServiceProvider.getLastName());
    return new ApiResponse<>(HttpStatus.OK.value(), subscriberWeightsDto);
  }
}
