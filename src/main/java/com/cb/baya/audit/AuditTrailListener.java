//package com.cb.baya.audit;
//
//
//import javax.persistence.EntityManager;
//import javax.persistence.PrePersist;
//import javax.persistence.PreRemove;
//import javax.persistence.PreUpdate;
//import javax.transaction.Transactional;
//
//import static com.cb.baya.audit.Action.*;
//import static javax.transaction.Transactional.TxType.MANDATORY;
//
//public class AuditTrailListener {
//
//  @PrePersist
//  public void prePersist(Object target) {
//    perform(target, INSERTED);
//  }
//
//  @PreUpdate
//  public void preUpdate(Object target) {
//    perform(target, UPDATED);
//  }
//
//  @PreRemove
//  public void preRemove(Object target) {
//    perform(target, DELETED);
//  }
//
//  @Transactional(MANDATORY)
//  void perform(Object target, Action action) {
//    EntityManager entityManager = AuditBeanUtil.getBean(EntityManager.class);
//    entityManager.persist(new AuditTrail(target, action));
//  }
//}