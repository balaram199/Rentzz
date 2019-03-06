package com.grabasset.csr.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import com.grabasset.csr.dto.CityDto;
import com.grabasset.csr.dto.CountryDto;
import com.grabasset.csr.dto.StateDto;
import com.grabasset.user.bo.CityBo;
import com.grabasset.user.bo.CountryBo;
import com.grabasset.user.bo.StateBo;

@Component
public class Mapper {

	public List<CityDto> mapCityBoToCityDto(List<CityBo> cityBos) {
		CityDto CityDto = null;
		List<CityDto> cityDtos = null;
		cityDtos = new ArrayList<>();
		for (CityBo CityBo : cityBos) {
			CityDto = new CityDto();
			CityDto.setCityId(CityBo.getCityId());
			CityDto.setCity(CityBo.getCity());
			cityDtos.add(CityDto);
		}
		return cityDtos;
	}

	public List<StateDto> mapStateBoToStateDto(List<StateBo> StateBos) {

		StateDto StateDto = null;
		List<StateDto> StateDtos = null;
		StateDtos = new ArrayList<>();
		for (StateBo StateBo : StateBos) {
			StateDto = new StateDto();
			StateDto.setStateId(StateBo.getStateId());
			StateDto.setState(StateBo.getState());
			StateDtos.add(StateDto);
		}
		return StateDtos;
	}

	public List<CountryDto> mapCountryBoToCountryDto(List<CountryBo> countryBos) {

		CountryDto countryDto = null;
		List<CountryDto> countryDtos = null;
		countryDtos = new ArrayList<>();
		for (CountryBo countryBo : countryBos) {
			countryDto = new CountryDto();
			countryDto.setCountryId(countryBo.getCountryId());
			countryDto.setCountry(countryBo.getCountry());
			countryDtos.add(countryDto);
		}
		return countryDtos;
	}
}
