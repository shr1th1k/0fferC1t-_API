package com.offerciti.model.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.offerciti.model.User;

@Repository 
public interface UserDao extends CrudRepository<User,Integer> {

}
