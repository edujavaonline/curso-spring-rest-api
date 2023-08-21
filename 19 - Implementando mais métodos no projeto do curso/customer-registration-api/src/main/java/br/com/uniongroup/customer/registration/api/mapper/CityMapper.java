package br.com.uniongroup.customer.registration.api.mapper;

import br.com.uniongroup.customer.registration.api.controller.request.CityRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CityResponse;
import br.com.uniongroup.customer.registration.api.model.City;
import br.com.uniongroup.customer.registration.api.model.State;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CityMapper {

    @Autowired
    private ModelMapper mapper;

    public CityResponse fromCityToCityResponse(City city) {
        return mapper.map(city, CityResponse.class);
    }

    public List<CityResponse> fromListCityToListCityResponse(List<City> cities) {
        return cities.stream()
                .map(city -> fromCityToCityResponse(city))
                .collect(Collectors.toList());
    }

    public City fromCityRequestToCity(CityRequest cityRequest) {
        return mapper.map(cityRequest, City.class);
    }

    public void fromCityRequestToCity(CityRequest cityRequest, City city) {
        if (city.getState() != null) {
            city.setState(new State());
        }
        mapper.map(cityRequest, city);
    }
}
