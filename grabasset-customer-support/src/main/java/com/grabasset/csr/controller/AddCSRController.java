package com.grabasset.csr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.grabasset.csr.bo.CSRDetailsBo;
import com.grabasset.csr.dto.CityDto;
import com.grabasset.csr.dto.CountryDto;
import com.grabasset.csr.dto.StateDto;
import com.grabasset.csr.form.CSRRegistrationForm;
import com.grabasset.csr.mapper.CSRMapper;
import com.grabasset.csr.mapper.Mapper;
import com.grabasset.csr.service.ManageCsrService;
import com.grabasset.csr.validator.CSRDetailsValidator;

@Controller
@RequestMapping("/add-csr.htm")
public class AddCSRController {

	@Autowired
	private ManageCsrService manageCsrService;

	@Autowired
	private CSRDetailsValidator csrdetailsValidator;

	@Autowired
	private CSRMapper csrMapper;

	@Autowired
	private Mapper mapper;

	@GetMapping
	public String showAddCSRForm(Model model) {
		model.addAttribute("csrRegistration", new CSRRegistrationForm());
		return "csr-registration-form";
	}

	@PostMapping
	public String registerAddCSR(Model model, @ModelAttribute("csrRegistration") CSRRegistrationForm csrForm,
			BindingResult errors) {

		CSRDetailsBo csrdetailsBo = null;

		if (csrdetailsValidator.supports(csrForm.getClass())) {

			csrdetailsValidator.validate(csrForm, errors);
			if (errors.hasErrors()) {
				return "csr-registration-form";
			}
		}
		csrdetailsBo = csrMapper.mapCSRFormToCsrDetailsBo(csrForm);
		manageCsrService.registerCsr(csrdetailsBo);
		return "csr-registration-success";
	}

	@ModelAttribute("cities")
	public List<CityDto> getcities() {
		return mapper.mapCityBoToCityDto(manageCsrService.getCities());
	}

	@ModelAttribute("states")
	public List<StateDto> getStates() {
		return mapper.mapStateBoToStateDto(manageCsrService.getStates());
	}

	@ModelAttribute("countries")
	public List<CountryDto> getCountries() {
		return mapper.mapCountryBoToCountryDto(manageCsrService.getCountries());

	}
}
