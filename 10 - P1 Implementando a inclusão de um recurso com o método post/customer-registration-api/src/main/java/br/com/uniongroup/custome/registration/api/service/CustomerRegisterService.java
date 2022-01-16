package br.com.uniongroup.custome.registration.api.service;

import br.com.uniongroup.custome.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.custome.registration.api.mapper.CustomerRegisterMapper;
import br.com.uniongroup.custome.registration.api.model.CustomerRegister;
import br.com.uniongroup.custome.registration.api.repository.CustomerRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerRegisterService {

    @Autowired
    private CustomerRegisterRepository customerRegisterRepository;

    @Autowired
    private CustomerRegisterMapper customerRegisterMapper;

    @Transactional
    public void save(CustomerRegisterRequest customerRegisterRequest) {
        CustomerRegister customerRegister = customerRegisterMapper.fromCustomerRegisterRequestToCustomerRegister(customerRegisterRequest);
        customerRegisterRepository.save(customerRegister);
    }
}
