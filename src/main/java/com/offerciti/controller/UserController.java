package com.offerciti.controller;
import java.util.Calendar;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.offerciti.model.User;
import com.offerciti.service.UserService;

@RestController
public class UserController {
  
  @Autowired
  private UserService userService;
  
  @RequestMapping(value="offerciti/user/create",method=RequestMethod.POST)
  public @ResponseBody User createUser(@RequestBody User user) {
      user.setCreatedDate(Calendar.getInstance());
      user.setLastLogin(Calendar.getInstance());
      return  userService.createUser(user);
  }
  
  @RequestMapping(value="offerciti/user/{id}",method=RequestMethod.GET)
  public @ResponseBody User getUser(@PathVariable int id) {
      return userService.getUser(id);
  }
  
  @RequestMapping(value="offerciti/user/delete/{id}",method=RequestMethod.GET)
  public void deleteUser(@PathVariable int id) {
       userService.deleteUser(id);
  }
  
  @RequestMapping(value="offerciti/users",method=RequestMethod.GET)
  public @ResponseBody List<User> getAllUsers() {
      return userService.getAllUsers();
  }

}
