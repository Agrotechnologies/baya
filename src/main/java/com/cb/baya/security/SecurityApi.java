package com.cb.baya.security;//package com.cbsolutions.smartfarmer.security;
//
//
//import com.cbsolutions.smartfarmer.common.ApiResponse;
//import com.cbsolutions.smartfarmer.user.CustomUserDetailsService;
//import com.cbsolutions.smartfarmer.user.LoginRequest;
//import com.cbsolutions.smartfarmer.user.UserPrincipal;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.*;
//
//@Slf4j
//@RestController
//@RequestMapping("/login")
//@RequiredArgsConstructor
//public class SecurityApi {
//
//    private final SecurityService securityService;
//    private final CustomUserDetailsService customUserDetailsService;
//
//    @PostMapping
//    public ApiResponse<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
//        final LoginResponse loginResponse = securityService.authenticate(loginRequest);
//        return new ApiResponse<>(HttpStatus.OK.value(), loginResponse);
//    }
//
//    @GetMapping
//    public ApiResponse<UserDetails> getUserDetails(Authentication authentication) {
//        UserPrincipal principal = ((UserPrincipal) authentication.getPrincipal());
//        final UserDetails userDetails = customUserDetailsService.loadUserByUsername(principal.getUsername());
//        return new ApiResponse<>(HttpStatus.OK.value(), userDetails);
//    }
//
//
//}