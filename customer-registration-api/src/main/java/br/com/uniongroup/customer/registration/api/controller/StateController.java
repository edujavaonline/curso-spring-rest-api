package br.com.uniongroup.customer.registration.api.controller;

import br.com.uniongroup.customer.registration.api.controller.response.StateResponse;
import br.com.uniongroup.customer.registration.api.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<StateResponse> findAll() {
        return stateService.findAll();
    }

    @GetMapping(value = "/{id}")
    public StateResponse findById(@PathVariable Long id) {
        return stateService.findById(id);
    }
}
