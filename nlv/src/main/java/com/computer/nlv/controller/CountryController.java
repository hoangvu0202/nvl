package com.computer.nlv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.computer.nlv.service.CountryService;

@Controller
public class CountryController {

	@Autowired
	CountryService countryService;
	
	@RequestMapping(value = { "/country" }, method = RequestMethod.GET)
	public String index(Model model) {

		model.addAttribute("countryService", countryService.countriesList());

		return "index";
	}
}
