package com.offerciti.repository;

import org.springframework.data.repository.CrudRepository;

import com.offerciti.model.Merchant;

public interface MerchantRepository extends CrudRepository<Merchant, Integer> {

}
