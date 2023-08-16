package br.com.uniongroup.customer.registration.api.service;

import br.com.uniongroup.customer.registration.api.controller.request.CustomerRegisterRequest;
import br.com.uniongroup.customer.registration.api.controller.response.CustomerRegisterResponse;
import br.com.uniongroup.customer.registration.api.mapper.CustomerRegisterMapper;
import br.com.uniongroup.customer.registration.api.model.City;
import br.com.uniongroup.customer.registration.api.model.CustomerRegister;
import br.com.uniongroup.customer.registration.api.repository.CustomerRegisterRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Map;

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

    @Transactional
    public CustomerRegisterResponse updatePatch(Long id, Map<String, Object> fields) {
        CustomerRegister customerRegister = findOne(id);
        merge(fields, customerRegister);
        City city = cityService.findById(customerRegister.getAddress().getCity().getId());
        customerRegister.getAddress().setCity(city);
        customerRegister = customerRegisterRepository.save(customerRegister);
        return customerRegisterMapper.fromCustomerRegisterToCustomerResponse(customerRegister);
    }

    @Transactional
    public void active(Long id) {
        CustomerRegister customerRegister = findOne(id);
        customerRegister.active();
    }

    @Transactional
    public void inactive(Long id) {
        CustomerRegister customerRegister = findOne(id);
        customerRegister.inactive();
    }

    private void merge(Map<String, Object> fields, CustomerRegister customerRegister) {
        ObjectMapper objectMapper = new ObjectMapper();
        CustomerRegister customerRegisterConvert = objectMapper.convertValue(fields, CustomerRegister.class);
        fields.forEach((propertyName, propertyValue) -> {
            Field field = ReflectionUtils.findField(CustomerRegister.class, propertyName);
            field.setAccessible(true);

            Object newValue = ReflectionUtils.getField(field, customerRegisterConvert);

            ReflectionUtils.setField(field, customerRegister, newValue);
        });
    }

    private CustomerRegister findOne(Long id) {
        return customerRegisterRepository.findById(id).get();
    }
}
