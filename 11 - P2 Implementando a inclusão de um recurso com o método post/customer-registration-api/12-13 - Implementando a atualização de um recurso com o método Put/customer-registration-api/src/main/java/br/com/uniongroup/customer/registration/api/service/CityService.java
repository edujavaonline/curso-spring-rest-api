package br.com.uniongroup.customer.registration.api.service;

import br.com.uniongroup.customer.registration.api.model.City;
import br.com.uniongroup.customer.registration.api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }
}
