package br.com.uniongroup.customer.registration.api.service;

import br.com.uniongroup.customer.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CustomerRegisterResponse;
import br.com.uniongroup.customer.registration.api.mapper.CustomerRegisterMapper;
import br.com.uniongroup.customer.registration.api.model.City;
import br.com.uniongroup.customer.registration.api.model.CustomerRegister;
import br.com.uniongroup.customer.registration.api.repository.CustomerRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerRegisterService {

    @Autowired
    private CustomerRegisterRepository customerRegisterRepository;

    @Autowired
    private CustomerRegisterMapper customerRegisterMapper;

    @Autowired
    private CityService cityService;

    @Transactional
    public CustomerRegisterResponse save(CustomerRegisterRequest customerRegisterRequest) {
        CustomerRegister customerRegister = customerRegisterMapper.fromCustomerRegisterRequestToCustomerRegister(customerRegisterRequest);
        customerRegister = customerRegisterRepository.save(customerRegister);
        return customerRegisterMapper.fromCustomerRegisterToCustomerResponse(customerRegister);
    }

    @Transactional
    public CustomerRegisterResponse update(Long id, CustomerRegisterRequest customerRegisterRequest) {
        CustomerRegister customerRegister = findOne(id);
        customerRegisterMapper.fromCustomerRegisterRequestToCustomerRegister(customerRegisterRequest, customerRegister);
        City city = cityService.findById(customerRegister.getAddress().getCity().getId());
        customerRegister.getAddress().setCity(city);
        customerRegister = customerRegisterRepository.save(customerRegister);
        return customerRegisterMapper.fromCustomerRegisterToCustomerResponse(customerRegister);
    }

    private CustomerRegister findOne(Long id) {
        return customerRegisterRepository.findById(id).get();
    }
}
