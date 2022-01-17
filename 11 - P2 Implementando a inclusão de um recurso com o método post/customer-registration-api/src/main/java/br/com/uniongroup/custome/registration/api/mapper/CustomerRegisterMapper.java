package br.com.uniongroup.custome.registration.api.mapper;

import br.com.uniongroup.custome.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.custome.registration.api.model.CustomerRegister;
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
}
