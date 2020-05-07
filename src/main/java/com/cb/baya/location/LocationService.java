package com.cb.baya.location;

import java.util.List;

public interface LocationService {

  List<Province> getAll();

  Province findById(Long id);
}
