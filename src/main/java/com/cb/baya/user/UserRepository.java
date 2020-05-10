///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.cb.baya.user;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//
//
//public interface UserRepository extends JpaRepository<User, Long> {
//
////    User findOneByUsernameAndPassword(String username, String password);
//
//  User findByUsernameOrEmail(String username, String email);
//
//  User findOneByUsername(String username);
//
//  boolean existsByUsername(String username);
//
//  boolean existsByEmail(String email);
//
//  @Modifying
//  @Query(value = "Delete from user where id=?1", nativeQuery = true)
//  @Override
//  void deleteById(Long id);
//}
