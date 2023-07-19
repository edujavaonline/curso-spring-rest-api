package br.com.uniongroup.customer.registration.api.mapper;

import br.com.uniongroup.customer.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CustomerRegisterResponse;
import br.com.uniongroup.customer.registration.api.model.City;
import br.com.uniongroup.customer.registration.api.model.CustomerRegister;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRegisterMapper {

    @Autowired
    private ModelMapper mapper;

    public CustomerRegister fromCustomerRegisterRequestToCustomerRegister(CustomerRegisterRequest customerRegisterRequest) {
        return mapper.map(customerRegisterRequest, CustomerRegister.class);
    }

    public void fromCustomerRegisterRequestToCustomerRegister(CustomerRegisterRequest customerRegisterRequest, CustomerRegister customerRegister) {
        if (customerRegister.getAddress() != null) {
            customerRegister.getAddress().setCity(new City());
        }
        mapper.map(customerRegisterRequest, customerRegister);
    }

    public CustomerRegisterResponse fromCustomerRegisterToCustomerResponse(CustomerRegister customerRegister) {
        return mapper.map(customerRegister, CustomerRegisterResponse.class);
    }
}
