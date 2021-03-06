package com.offerciti.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.offerciti.model.User;

@Repository 
public interface UserRepository extends CrudRepository<User,Integer> {

  public User findByEmail(String userName);

  
}
