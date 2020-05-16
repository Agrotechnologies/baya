package com.cb.baya.config;

import com.cb.baya.batches.Batches;
import com.cb.baya.batches.BatchesDto;
import com.cb.baya.bhero.Bhero;
import com.cb.baya.bhero.BheroDto;
import com.cb.baya.farmer.Farmer;
import com.cb.baya.farmer.FarmerDto;
import com.cb.baya.job.JobRequest;
import com.cb.baya.job.JobRequestDto;
import com.cb.baya.location.Province;
import com.cb.baya.location.ProvinceDto;
import com.cb.baya.operation.Operation;
import com.cb.baya.operation.OperationDto;
import com.cb.baya.payments.Payment;
import com.cb.baya.payments.PaymentDto;
import com.cb.baya.serviceimplement.ServiceImplement;
import com.cb.baya.serviceimplement.ServiceImplementDto;
import com.cb.baya.serviceweights.SubscriberWeights;
import com.cb.baya.serviceweights.SubscriberWeightsDto;
import com.cb.baya.tsp.ServiceProvider;
import com.cb.baya.tsp.ServiceProviderDto;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TypeMapper {


  ServiceProvider map(ServiceProviderDto providerDto);

  ServiceProviderDto map(ServiceProvider serviceProvider);

  SubscriberWeightsDto map(SubscriberWeights subscriberWeights);

  JobRequest map(JobRequestDto jobRequestDto);

  JobRequestDto map(JobRequest jobCreated);


  ServiceImplement map(ServiceImplementDto serviceImplementDto);

  ServiceImplementDto map(ServiceImplement serviceImplement);

  Operation map(OperationDto operationDto);

  OperationDto map(Operation operationCreated);

  ProvinceDto map(Province province);

  Payment map(PaymentDto paymentDto);

  PaymentDto map(Payment payment);


  Farmer map(FarmerDto farmerDto);

  FarmerDto map(Farmer farmer);

  Bhero map(BheroDto bheroDto);

  BheroDto map(Bhero bhero);


  Batches map(BatchesDto batchesDto);

  BatchesDto map(Batches batches);
}

