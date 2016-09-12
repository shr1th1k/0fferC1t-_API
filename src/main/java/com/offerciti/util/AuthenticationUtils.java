package com.offerciti.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.*;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.offerciti.model.User;

@Component
public class AuthenticationUtils {
  private long expiration = 500000;
  private String secret = "@#$!@##ASFDGG";
  public String generateToken(UserDetails userDetails) {
    Map<String,Object> claims = new HashMap<String,Object>();
    claims.put("sub", userDetails.getUsername());
    claims.put("created", Calendar.getInstance().getTime());
    String token =  Jwts.builder().setClaims(claims).
        setExpiration(new Date(Calendar.getInstance().getTimeInMillis()+this.expiration * 1000))
        .signWith(SignatureAlgorithm.HS512, secret).compact();
    return token;
  }
  public String getUserName(String authToken) {
    String userName;
    try{
      final Claims claims = getClaimsFromToken(authToken, secret);
      userName = claims.getSubject();
    }catch(Exception e){
      userName = null;
    }
    return userName;
  }
  public Date getCreatedDate(String authToken) {
    Date createdDate;
    try{
      final Claims claims = getClaimsFromToken(authToken, secret);
      createdDate = claims.getIssuedAt();
    }catch(Exception e){
      createdDate = null;
    }
    return createdDate;
  }
  
  public Date getExpirationDate(String authToken) {
    Date expriedDate;
    try{
      final Claims claims = getClaimsFromToken(authToken, secret);
      expriedDate = claims.getExpiration();
    }catch(Exception e){
      expriedDate = null;
    }
    return expriedDate;
  }
  public boolean validateToken(String authToken, UserDetails userDetails) {
    User user = (User)userDetails;
    Claims claims = getClaimsFromToken(authToken, secret);
    final String username = getUserName(authToken);
    final Date created = getCreatedDate(authToken);
    final Date expiration = getExpirationDate(authToken);
    return (username.equals(user.getEmail()) && !(isTokenExpired(authToken)));
  }
  private boolean isTokenExpired(String authToken) {
    final Date expiration = getExpirationDate(authToken);
    return expiration.before(Calendar.getInstance().getTime());
  }
  private Claims getClaimsFromToken(String token,String secret) {
    Claims claims;
    try {
      claims = Jwts.parser()
        .setSigningKey(secret)
        .parseClaimsJws(token)
        .getBody();
    } catch (Exception e) {
      claims = null;
    }
    return claims;
  }

}
