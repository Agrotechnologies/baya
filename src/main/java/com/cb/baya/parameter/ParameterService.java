package com.cb.baya.parameter;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ParameterService {

  <T> T getParameterValue(String parameterName, Class<T> requiredType);

  Map<String, String> getParameterValues(String... parameterNames);

  List<Parameter> findAll();

  Parameter save(Parameter parameter);
}
