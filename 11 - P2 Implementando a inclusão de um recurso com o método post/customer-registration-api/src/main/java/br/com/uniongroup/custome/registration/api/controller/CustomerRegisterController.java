package br.com.uniongroup.custome.registration.api.controller;

import br.com.uniongroup.custome.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.custome.registration.api.service.CustomerRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer-register")
public class CustomerRegisterController {

    @Autowired
    private CustomerRegisterService customerRegisterService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CustomerRegisterRequest customerRegisterRequest) {
        customerRegisterService.save(customerRegisterRequest);
    }
}
