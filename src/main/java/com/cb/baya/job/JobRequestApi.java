package com.cb.baya.job;

import com.cb.baya.common.ApiResponse;
import com.cb.baya.common.CrudApi;
import com.cb.baya.common.PaginationResult;
import com.cb.baya.config.TypeMapper;
import com.cb.baya.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/job")
@RequiredArgsConstructor
public class JobRequestApi implements CrudApi<JobRequestDto> {

  private final TypeMapper mapper;
  private final JobRequestService jobRequestService;


  @Override
  public ApiResponse<JobRequestDto> create(JobRequestDto jobRequestDto) {
    log.info("Creating a Job Request {}", jobRequestDto);
    final JobRequest jobCreated = jobRequestService.createJobRequest(mapper.map(jobRequestDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(jobCreated));
  }

  @Override
  public ApiResponse<JobRequestDto> update(JobRequestDto jobRequestDto) {
    log.info("Updating Job Request {}", jobRequestDto);
    final JobRequest jobCreated = jobRequestService.updateJobRequest(mapper.map(jobRequestDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(jobCreated));
  }

  @Override
  public ApiResponse<JobRequestDto> delete(JobRequestDto jobRequestDto) {
    jobRequestService.deleteJobRequest(mapper.map(jobRequestDto));
    return new ApiResponse<>(HttpStatus.OK.value(), "Deleted");
  }

  @Override
  public ApiResponse<PaginationResult<JobRequestDto>> findAll(String search, Integer page, Integer size, String sortBy) {

    List<JobRequest> jobRequests = null;
    if (search.isEmpty()) {
      jobRequests = jobRequestService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)));
    } else {
      //  jobRequests = jobRequestService.search(search, page - 1, size, Sort.by(sortBy));
    }

    List<JobRequestDto> jobRequestDtos = jobRequests //jobRequestService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<JobRequestDto> pagedJobRequests = PaginationResult.pagination(jobRequestDtos, jobRequestService.getNumberOfJobs(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedJobRequests);
  }

  @Override
  public ApiResponse<JobRequestDto> find(Long id) {
    Optional<JobRequest> jobRequestOptional = jobRequestService.findById(id);
    return new ApiResponse<>(HttpStatus.OK.value(),
      mapper.map(jobRequestOptional.orElseThrow(() -> new BusinessException("Could not find job request with id " + id))));
  }
}
