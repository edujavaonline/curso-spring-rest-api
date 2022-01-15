package br.com.uniongroup.custome.registration.api.controller;

import br.com.uniongroup.custome.registration.api.controller.response.StateResponse;
import br.com.uniongroup.custome.registration.api.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
