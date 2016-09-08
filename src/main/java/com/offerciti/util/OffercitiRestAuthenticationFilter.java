package com.offerciti.util;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

public class OffercitiRestAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  private static final String FILTER_APPLIED = null;


  public OffercitiRestAuthenticationFilter(String defaultFilterProcessesUrl) {
    super(defaultFilterProcessesUrl);
}

private final String HEADER_SECURITY_TOKEN = "X-Token"; 
private String token = "";


@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

    this.token = request.getHeader(HEADER_SECURITY_TOKEN);

    //If we have already applied this filter - not sure how that would happen? - then just continue chain
    if (request.getAttribute(FILTER_APPLIED) != null) {
        chain.doFilter(request, response);
        return;
    }

    //Now mark request as completing this filter
    request.setAttribute(FILTER_APPLIED, Boolean.TRUE);

    //Attempt to authenticate
    Authentication authResult;
    authResult = attemptAuthentication(request, response);
    if (authResult == null) {
        unsuccessfulAuthentication(request, response, new LockedException("Forbidden"));
    } else {
        successfulAuthentication(request, response, chain, authResult);
    }
}

/**
 * Attempt to authenticate request - basically just pass over to another method to authenticate request headers 
 */
@Override public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
    AbstractAuthenticationToken userAuthenticationToken = authUserByToken();
    if(userAuthenticationToken == null) throw new AuthenticationServiceException(MessageFormat.format("Error | {0}", "Bad Token"));
    return userAuthenticationToken;
}


/**
 * authenticate the user based on token, mobile app secret & user agent
 * @return
 */
private AbstractAuthenticationToken authUserByToken() {
    AbstractAuthenticationToken authToken = null;
    try {
        // TODO - just return null - always fail auth just to test spring setup ok
        return null;
    } catch (Exception e) {
        logger.error("Authenticate user by token error: ", e);
    }
    return authToken;
}

}
