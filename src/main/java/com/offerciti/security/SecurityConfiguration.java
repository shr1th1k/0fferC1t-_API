package com.offerciti.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.offerciti.util.OffecitiRequestAwareAuthenticationSuccessHandler;
import com.offerciti.util.RestAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
  
  @Autowired
  private OffecitiRequestAwareAuthenticationSuccessHandler authenticationSuccessHandler;
  
  @Autowired
  private OfferCitiUserDetailsService offerCitiUserDetailsService;
  
  
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
      return super.authenticationManagerBean();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsServiceBean() throws Exception {
      return super.userDetailsServiceBean();
  }

  
  @Override
  protected void configure(org.springframework.security.config.annotation.web.builders.HttpSecurity http) throws Exception {
    http
    .csrf().disable()
    .exceptionHandling()
    .authenticationEntryPoint(restAuthenticationEntryPoint)
    .and()
    .authorizeRequests()
    .antMatchers("/offerciti/*").authenticated()
    .and()
    .formLogin()
    .permitAll()
    .loginProcessingUrl("/offerciti/login")
    .successHandler(authenticationSuccessHandler)
    .failureHandler(new SimpleUrlAuthenticationFailureHandler())
    .and()
    .logout();

    /*http
    .csrf()
        .disable()
        .addFilter(restAuthenticationFilter())
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint()).and()
        .antMatcher("/v1/**")
        .authorizeRequests()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/mobile/app/sign-up").permitAll()
        .antMatchers("/v1/**").permitAll()
        .anyRequest().authenticated()
        .and()
    .formLogin()
        .loginPage("/")
        .loginProcessingUrl("/loginprocess")
        .failureUrl("/?loginFailure=true")
        .permitAll();*/
    /*http.authorizeRequests().antMatchers("/**","/resources/**","/signup","/swagger-ui.html").permitAll()
    .and().formLogin().permitAll().loginProcessingUrl("/offerciti/login").usernameParameter("userName").passwordParameter("password")
    .and().logout().permitAll();
    http.authorizeRequests().anyRequest().authenticated();*/
  };
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      /*auth.inMemoryAuthentication().
        withUser("temporary").password("temporary").roles("ADMIN").and().
        withUser("user").password("userPass").roles("USER");*/
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(offerCitiUserDetailsService);
    auth.authenticationProvider(authenticationProvider);
  }
  
  
 /* @Autowired
  public void enableGlobal(OfferCitiUserDetailsService offerCitiUserDetailsService,AuthenticationManagerBuilder auth) throws Exception{
    auth.userDetailsService(offerCitiUserDetailsService);
  }*/
  
  @Bean
  public OffecitiRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
      return new OffecitiRequestAwareAuthenticationSuccessHandler();
  }
  @Bean
  public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
      return new SimpleUrlAuthenticationFailureHandler();
  }

}
