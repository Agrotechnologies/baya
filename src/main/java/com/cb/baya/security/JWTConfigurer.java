package com.cb.baya.security;//package com.cbsolutions.smartfarmer.security;
//
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//
//
//    private final JwtTokenProvider jwtTokenProvider;
//
//
//    private JwtAuthenticationFilter jwtAuthenticationFilter;
//
//    public JWTConfigurer(JwtTokenProvider jwtTokenProvider, JwtAuthenticationFilter jwtAuthenticationFilter) {
//        this.jwtTokenProvider = jwtTokenProvider;
//        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
////        JwtAuthenticationFilter customFilter = new JwtAuthenticationFilter();
//        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//
//
//}
