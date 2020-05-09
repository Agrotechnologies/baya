package com.cb.baya.computations.redemption;

import com.cb.baya.common.ApiResponse;
import com.cb.baya.computations.redemption.data.PaymentRequest;
import com.cb.baya.computations.redemption.data.PaymentsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/points")
public class PaymentsRedemptionApi {


  private final PaymentsRedemptionService redemptionService;

  @PostMapping(value = "/redeem")
  public ApiResponse<PaymentsResponse> redeemPoints(@RequestBody PaymentRequest paymentRequest) {
    log.info("Processing points redemption request {}", paymentRequest);
    final PaymentsResponse paymentsResponse = redemptionService.redeem(paymentRequest);
    log.info("redemption response {}", paymentsResponse);
    return new ApiResponse<>(HttpStatus.OK.value(), paymentsResponse);
  }
}
