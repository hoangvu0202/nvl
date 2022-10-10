package com.computer.nlv.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.computer.nlv.entity.CountriesEntity;

@Repository
public interface CountriesRepository extends CrudRepository<CountriesEntity, Integer> {

}
