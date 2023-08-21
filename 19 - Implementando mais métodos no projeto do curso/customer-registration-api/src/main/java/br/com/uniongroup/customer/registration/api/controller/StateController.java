package br.com.uniongroup.customer.registration.api.controller;

import br.com.uniongroup.customer.registration.api.controller.request.StateRequest;
import br.com.uniongroup.customer.registration.api.controller.response.StateResponse;
import br.com.uniongroup.customer.registration.api.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StateResponse> findAll() {
        return stateService.findAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StateResponse findOne(@PathVariable Long id) {
        return stateService.findOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StateResponse save(@RequestBody StateRequest stateRequest) {
        return stateService.save(stateRequest);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StateResponse update(@PathVariable Long id, @RequestBody StateRequest stateRequest) {
        return stateService.update(id, stateRequest);
    }
}
