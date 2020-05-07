package com.cb.baya.security;//package com.cbsolutions.smartfarmer.security;
//
//
//import com.cbsolutions.smartfarmer.user.CustomUserDetailsService;
//import com.cbsolutions.smartfarmer.user.LoginRequest;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpClientErrorException;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class SercurityServiceImpl implements SecurityService {
//
//    private final AuthenticationManager authenticationManager;
//
//    private final JwtTokenProvider tokenProvider;
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    @Override
//    public LoginResponse authenticate(LoginRequest loginRequest) {
//
//        if (loginRequest.getUsername().isEmpty() || loginRequest.getPassword().isEmpty()) {
//            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "Login failed");
//        }
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//
//        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
//        String jwt = tokenProvider.generateToken(authentication);
//        return new LoginResponse(jwt, userDetails);
//    }
//}
