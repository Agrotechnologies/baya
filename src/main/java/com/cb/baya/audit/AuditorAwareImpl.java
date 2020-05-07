package com.cb.baya.audit;

import com.cb.baya.user.UserPrincipal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Slf4j
public class AuditorAwareImpl implements AuditorAware<String> {


  @Override
  public Optional<String> getCurrentAuditor() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication == null
      || !authentication.isAuthenticated()
      || ((authentication.getPrincipal() instanceof String)
      && ((String) authentication.getPrincipal()).equalsIgnoreCase("anonymousUser")
    )) {
      return Optional.of("USSD");
    }
    log.info("Audit user :{}", ((UserPrincipal) authentication.getPrincipal()).getUsername());
    return Optional.of(((UserPrincipal) authentication.getPrincipal()).getUsername());
  }

}
