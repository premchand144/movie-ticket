package com.demo.movieticket.repositories;

import com.demo.movieticket.entities.DiscountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepository extends CrudRepository<DiscountEntity, Integer> {

    List<DiscountEntity> findByCityIdAndTheaterId(Integer cityId, Integer theaterId);
}
