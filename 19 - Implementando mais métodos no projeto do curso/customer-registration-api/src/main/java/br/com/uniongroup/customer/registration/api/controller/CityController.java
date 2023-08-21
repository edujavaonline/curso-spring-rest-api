package br.com.uniongroup.customer.registration.api.controller;

import br.com.uniongroup.customer.registration.api.controller.request.CityRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CityResponse;
import br.com.uniongroup.customer.registration.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CityResponse> findAll() {
        return cityService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CityResponse findOne(@PathVariable Long id) {
        return cityService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CityResponse save( @RequestBody CityRequest cityRequest) {
        return cityService.save(cityRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CityResponse update(@PathVariable Long id, @RequestBody CityRequest cityRequest) {
        return cityService.update(id, cityRequest);
    }
}
