package br.com.uniongroup.customer.registration.api.service;

import br.com.uniongroup.customer.registration.api.controller.request.CityRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CityResponse;
import br.com.uniongroup.customer.registration.api.mapper.CityMapper;
import br.com.uniongroup.customer.registration.api.model.City;
import br.com.uniongroup.customer.registration.api.model.State;
import br.com.uniongroup.customer.registration.api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateService stateService;

    @Autowired
    private CityMapper cityMapper;

    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    public CityResponse findOne(Long id) {
        City city = findById(id);
        return cityMapper.fromCityToCityResponse(city);
    }

    public List<CityResponse> findAll() {
        List<City> cities = cityRepository.findAll();
        return cityMapper.fromListCityToListCityResponse(cities);
    }

    @Transactional
    public CityResponse save(CityRequest cityRequest) {
        City city = cityMapper.fromCityRequestToCity(cityRequest);
        validateState(city);
        city = cityRepository.save(city);
        return cityMapper.fromCityToCityResponse(city);
    }

    @Transactional
    public CityResponse update(Long id, CityRequest cityRequest) {
        City city = findById(id);
        cityMapper.fromCityRequestToCity(cityRequest, city);
        validateState(city);
        return cityMapper.fromCityToCityResponse(city);
    }

    private void validateState(City city) {
        State state = stateService.findById(city.getState().getId());
        city.setState(state);
    }
}
