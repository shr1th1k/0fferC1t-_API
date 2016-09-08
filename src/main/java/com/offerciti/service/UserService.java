package com.offerciti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.offerciti.model.User;
import com.offerciti.repository.UserRepository;

@Component("userService")
public class UserService {

   @Autowired
   private UserRepository userRepository;
   
   public User createUser(User user){
     /*TODO
     BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
     user.setPassword(encoder.encode(user.getPassword()));*/
     return userRepository.save(user);
   }
   
   public User getUser(int id){
     return userRepository.findOne(id);
   }
   
   public void deleteUser(int id){
      userRepository.delete(id);
   }
   
   public List<User> getAllUsers(){
      return (List<User>)userRepository.findAll();
   }
}
