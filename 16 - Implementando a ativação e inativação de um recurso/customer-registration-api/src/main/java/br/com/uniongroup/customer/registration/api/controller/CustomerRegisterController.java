package br.com.uniongroup.customer.registration.api.controller;

import br.com.uniongroup.customer.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CustomerRegisterResponse;
import br.com.uniongroup.customer.registration.api.service.CustomerRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerRegisterResponse updatePatch(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return customerRegisterService.updatePatch(id, fields);
    }

    @PatchMapping("/{id}/active")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void active(@PathVariable Long id) {
        customerRegisterService.active(id);
    }

    @PatchMapping("/{id}/inactive")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void inactive(@PathVariable Long id) {
        customerRegisterService.inactive(id);
    }

}