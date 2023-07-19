package br.com.uniongroup.customer.registration.api.controller;

import br.com.uniongroup.customer.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CustomerRegisterResponse;
import br.com.uniongroup.customer.registration.api.service.CustomerRegisterService;
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
    public CustomerRegisterResponse save(@RequestBody CustomerRegisterRequest customerRegisterRequest) {
        return customerRegisterService.save(customerRegisterRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerRegisterResponse update(@PathVariable Long id, @RequestBody CustomerRegisterRequest customerRegisterRequest) {
        return customerRegisterService.update(id, customerRegisterRequest);
    }
}
