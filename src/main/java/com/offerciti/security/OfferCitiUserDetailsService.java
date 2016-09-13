package com.offerciti.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.offerciti.model.User;
import com.offerciti.repository.UserRepository;
@Component("offerCitiUserDetailsService")
public class OfferCitiUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;
  
  public OfferCitiUserDetailsService(){
    
  }
  
  public OfferCitiUserDetailsService(User user){
    
  }
  
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user =  userRepository.findByEmail(username);
    if(user != null){
      System.out.println("user loaded "+user.getFirstName()); 
    }
    
    if(user == null){
      throw new UsernameNotFoundException("User not found "+username);
    }
    return new OfferCitiUserDetails(user);
    
  }
  
  private static final class OfferCitiUserDetails extends User implements UserDetails{
    Collection<SimpleGrantedAuthority> list = null;
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private OfferCitiUserDetails(User user){
      super(user);
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
      list = new ArrayList<SimpleGrantedAuthority>();
      if(this.grantedAuthorities != null && this.grantedAuthorities.size() > 0){
        for(String grantedAuthority: this.grantedAuthorities){
          list.add(new SimpleGrantedAuthority(grantedAuthority));
        }
      }
      return this.list;
    }

    public String getUsername() {
      return this.email;
    }
    public String getPassword(){
      System.out.println("password is "+ password);
      return this.password;
    }
    public boolean isAccountNonExpired() {
      return true;
    }

    public boolean isAccountNonLocked() {
      return true;
    }

    public boolean isCredentialsNonExpired() {
      return true;
    }

    public boolean isEnabled() {
      return true;
    }
    
  }

}
