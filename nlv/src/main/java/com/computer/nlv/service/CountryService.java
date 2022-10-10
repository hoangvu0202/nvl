package com.computer.nlv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.computer.nlv.model.Countries;

@Service
public interface CountryService {

	List<Countries> countriesList();
}
