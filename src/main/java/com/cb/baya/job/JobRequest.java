package com.cb.baya.job;

import com.cb.baya.common.BaseEntity;
import com.cb.baya.location.District;
import com.cb.baya.operation.Operation;
import com.cb.baya.tsp.ServiceProvider;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "job_request", indexes = {@Index(name = "indx_job_request_msisdn", columnList = "msisdn", unique = false)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@Indexed
public class JobRequest extends BaseEntity {

  @Field
  @Column(name = "first_name", length = 50, nullable = false)
  private String firstName;

  @Field
  @Column(name = "last_name", length = 50, nullable = false)
  private String lastName;

  @Column(name = "totalBells", nullable = false)
  private BigDecimal numberOfBells;

  @Column(name = "scheme", nullable = true)
  private String scheme;

  @OneToOne
  @JoinColumn(name = "operation_id", referencedColumnName = "id")
  private Operation operation;

  @ManyToOne(fetch = FetchType.EAGER)
  private District district;

  @Column(name = "ward", nullable = false)
  private int ward;

  @Column(name = "estimatedWeight", nullable = false)
  private BigDecimal estimatedWeight;

  @Field
  @Column(name = "village", length = 50, nullable = false)
  private String village;

  @Field
  @Column(name = "msisdn", length = 9)
  private String msisdn;

  @Column(name = "distance_to_job")
  private BigDecimal distanceToJob;

  @Column(name = "status", nullable = false)
  @Enumerated(EnumType.STRING)
  private JobStatus status;

  @ManyToOne
  private ServiceProvider serviceProvider;

  @Column(name = "job_date")
  @Temporal(TemporalType.DATE)
  private Date jobDate;

}

