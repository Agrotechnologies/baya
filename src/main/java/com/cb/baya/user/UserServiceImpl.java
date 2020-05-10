//package com.cb.baya.user;
//
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//
//  private final UserRepository userRepository;
//
//  @Override
//  public User saveUser(User user) {
//    return userRepository.save(user);
//  }
//
//  @Override
//  public User update(User user) {
//    return userRepository.save(user);
//  }
//
//  @Override
//  public Optional<User> findById(Long id) {
//    return userRepository.findById(id);
//  }
//
//
//  @Override
//  public void delete(User user) {
//
//  }
//
//  @Override
//  public List<User> findAll(Integer page, Integer size, String sortBy) {
//    return userRepository.findAll(PageRequest.of(--page, size, Sort.by(sortBy))).getContent();
//  }
//
//  @Override
//  public Long total() {
//    return userRepository.count();
//  }
//}
