//package com.cb.baya.audit;
//
//
//import lombok.Data;
//import lombok.ToString;
//import org.springframework.data.annotation.CreatedBy;
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedBy;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;
//
//import javax.persistence.EntityListeners;
//import javax.persistence.MappedSuperclass;
//import javax.persistence.Temporal;
//import java.io.Serializable;
//import java.time.LocalDateTime;
//
//import static javax.persistence.TemporalType.TIMESTAMP;
//
//@Data
//@ToString
//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public abstract class AuditedEntity<U> implements Serializable {
//
//  @CreatedDate
//  @Temporal(TIMESTAMP)
//  protected LocalDateTime created;
//  @LastModifiedDate
//  @Temporal(TIMESTAMP)
//  protected LocalDateTime modified;
//  @CreatedBy
//  protected U createdBy;
//  @LastModifiedBy
//  protected U lastModifiedBy;
//
//}
