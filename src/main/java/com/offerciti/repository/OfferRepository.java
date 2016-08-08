package com.offerciti.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.offerciti.model.Offer;
@Repository
public interface OfferRepository extends CrudRepository<Offer, Integer> {

}
