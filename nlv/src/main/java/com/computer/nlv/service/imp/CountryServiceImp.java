package com.computer.nlv.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.computer.nlv.entity.CountriesEntity;
import com.computer.nlv.model.Countries;
import com.computer.nlv.repositories.CountriesRepository;
import com.computer.nlv.service.CountryService;

@Service
public class CountryServiceImp implements CountryService {

	@Autowired
	CountriesRepository repository;

	@Override
	public List<Countries> countriesList() {

		return copyCountriesList((List<CountriesEntity>) repository.findAll());
	}

	/**
	 * copyCountriesList
	 * 
	 * @param countriesEntitiesList
	 * @return List<Countries>
	 */
	private List<Countries> copyCountriesList(List<CountriesEntity> countriesEntitiesList) {
		
		if (null == countriesEntitiesList) {
			return new ArrayList<Countries>();
		}

		List<Countries> countriesList = new ArrayList<Countries>();
		List<CountriesEntity> entitiesList = (List<CountriesEntity>) repository.findAll();
		for (CountriesEntity entitie : entitiesList) {
			Countries countrie = new Countries();
			BeanUtils.copyProperties(entitie, countrie);
			countriesList.add(countrie);
		}
		return countriesList;
	}

}
