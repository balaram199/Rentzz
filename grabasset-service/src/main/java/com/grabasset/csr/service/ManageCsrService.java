package com.grabasset.csr.service;

import java.util.List;

import com.grabasset.csr.bo.CSRDetailsBo;
import com.grabasset.user.bo.CityBo;
import com.grabasset.user.bo.CountryBo;
import com.grabasset.user.bo.StateBo;

public interface ManageCsrService {

	void registerCsr(CSRDetailsBo csrDetailsBo);

	List<CityBo> getCities();

	List<StateBo> getStates();

	List<CountryBo> getCountries();

}
