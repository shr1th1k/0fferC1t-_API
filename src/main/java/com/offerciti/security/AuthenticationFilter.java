package com.offerciti.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import com.offerciti.util.AuthenticationUtils;

@ComponentScan(basePackageClasses={OfferCitiUserDetailsService.class,AuthenticationUtils.class})
public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private String token="X-Auth-Token";
  
  @Autowired
  private AuthenticationUtils authenticationUtils;
  
  @Autowired
  private OfferCitiUserDetailsService userDetailsService;
  
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest httpRequest = (HttpServletRequest) request;
    String authToken = httpRequest.getHeader(token);
    System.out.println(" token is"+ authToken);
    String userName = authenticationUtils.getUserName(authToken);
    System.out.println("user name is"+userName);
    if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
      UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
      if(authenticationUtils.validateToken(authToken,userDetails)){
        System.out.println("Inside valid token");
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    chain.doFilter(request, response);
  }

}
