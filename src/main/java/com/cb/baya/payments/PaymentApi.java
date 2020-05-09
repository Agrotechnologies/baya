package com.cb.baya.payments;

import com.cb.baya.common.ApiResponse;
import com.cb.baya.common.CrudApi;
import com.cb.baya.common.PaginationResult;
import com.cb.baya.config.TypeMapper;
import com.cb.baya.exception.BusinessException;
import com.cb.baya.serviceweights.SubscriberWeights;
import com.cb.baya.serviceweights.SubscriberWeightsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reward")
public class PaymentApi implements CrudApi<PaymentDto> {

  private final SubscriberWeightsService subscriberWeightsService;
  private final PaymentService paymentService;
  private final TypeMapper mapper;


  @GetMapping(value = "/eligible/{msisdn}")
  public ApiResponse<List<PaymentDto>> findEligibleRewards(@PathVariable("msisdn") final String msisdn) {

    final SubscriberWeights subscriberWeights = subscriberWeightsService.findByMsisdn(msisdn).
      orElseThrow(() -> new BusinessException("Susbcriber " + msisdn + " is not registered for vaya tractor club service"));
    final List<Payment> eligiblePayments = paymentService.findEligibleRewards(subscriberWeights.getWeightsDone());
    final List<PaymentDto> paymentDtoList = eligiblePayments.stream()
      .map(mapper::map)
      .collect(Collectors.toList());
    return new ApiResponse<>(HttpStatus.OK.value(), paymentDtoList);

  }

  @Override
  public ApiResponse<PaymentDto> create(PaymentDto paymentDto) {
    log.info("Create reward {}", paymentDto);
    final Payment payment = paymentService.save(mapper.map(paymentDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(payment));
  }

  @Override
  public ApiResponse<PaymentDto> update(PaymentDto paymentDto) {
    log.info("Update reward {}", paymentDto);
    final Payment payment = paymentService.update(mapper.map(paymentDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(payment));
  }

  @Override
  public ApiResponse<PaymentDto> delete(PaymentDto paymentDto) {

    return null;
  }

  @Override
  public ApiResponse<PaginationResult<PaymentDto>> findAll(String search, Integer page, Integer size, String sortBy) {

    List<PaymentDto> paymentDtos = paymentService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<PaymentDto> pagedRewards = PaginationResult.pagination(paymentDtos, paymentService.total(), page, size);

    return new ApiResponse<>(HttpStatus.OK.value(), pagedRewards);

  }

  @Override
  public ApiResponse<PaymentDto> find(Long id) {
    log.info("Find Reward {}", id);
    final Optional<Payment> rewardRecord = paymentService.findById(id);
    return rewardRecord.map(payment -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(payment)))
      .orElseThrow(
        () -> new BusinessException("Reward with Id " + id + "not found")
      );
  }
}
